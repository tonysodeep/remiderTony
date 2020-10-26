package com.example.remidertony

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.remidertony.AppView.ShowFragment
import com.example.remidertony.Database.ObjectData
import kotlinx.android.synthetic.main.fragment_add_item.*
import kotlinx.android.synthetic.main.fragment_add_item.view.*

class FragmentAddItem : Fragment() {

    private lateinit var showFragment: ShowFragment
    private lateinit var listObject: ListObject
    lateinit var objectData: ObjectData
    var name: String = ""
    var kind: String = ""
    var component: String = ""
    var statusOB: String = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val spinnerView: View = inflater!!.inflate(R.layout.fragment_add_item, container, false)
        showFragment = activity as BaseActivity
        listObject = activity as MainActivity

        //kind spinner
        val kinds = resources.getStringArray(R.array.objectKind)
        val arrayAdapterKind =
            ArrayAdapter(activity as MainActivity, android.R.layout.simple_spinner_item, kinds)
        spinnerView.spKind.adapter = arrayAdapterKind
        //base case
        val arrayNone = resources.getStringArray(R.array.noneArray)
        val arrayAdapterComponent =
            ArrayAdapter(activity as MainActivity, android.R.layout.simple_spinner_item, arrayNone)
        spinnerView.spComponent.adapter = arrayAdapterComponent

        spinnerView.spStatus.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (parent?.getItemAtPosition(position).toString() == "Moi mua") {
                    spinnerView.spComponent.visibility = View.INVISIBLE
                    val arrayAdapterComponent =
                        ArrayAdapter(activity as MainActivity, android.R.layout.simple_spinner_item, arrayNone)
                    spinnerView.spComponent.adapter = arrayAdapterComponent
                }
                if (parent?.getItemAtPosition(position).toString() == "Moi bao tri")
                    spinnerView.spComponent.visibility = View.VISIBLE


                statusOB = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }


        val xemayCompo = resources.getStringArray(R.array.xemayComponent)
        val tulanhCompo = resources.getStringArray(R.array.tuLanhComponent)
        val maylanhCompo = resources.getStringArray(R.array.mayLanhComponent)
        val maygiacCompo = resources.getStringArray(R.array.mayGiacComponent)

        spinnerView.spKind.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (parent?.getItemAtPosition(position).toString()) {
                    "Xe may" -> {
                        val arrayAdapterComponent =
                            ArrayAdapter(
                                activity as MainActivity,
                                android.R.layout.simple_spinner_item,
                                xemayCompo
                            )
                        spinnerView.spComponent.adapter = arrayAdapterComponent
                        kind = parent?.getItemAtPosition(position).toString()

                    }
                    "Tu lanh" -> {
                        val arrayAdapterComponent =
                            ArrayAdapter(
                                activity as MainActivity,
                                android.R.layout.simple_spinner_item,
                                tulanhCompo
                            )
                        spinnerView.spComponent.adapter = arrayAdapterComponent
                        kind = parent?.getItemAtPosition(position).toString()
                    }
                    "May giac" -> {
                        val arrayAdapterComponent =
                            ArrayAdapter(
                                activity as MainActivity,
                                android.R.layout.simple_spinner_item,
                                maygiacCompo
                            )
                        spinnerView.spComponent.adapter = arrayAdapterComponent
                        kind = parent?.getItemAtPosition(position).toString()
                    }
                    "Manh lanh" -> {
                        val arrayAdapterComponent =
                            ArrayAdapter(
                                activity as MainActivity,
                                android.R.layout.simple_spinner_item,
                                maylanhCompo
                            )
                        spinnerView.spComponent.adapter = arrayAdapterComponent
                        kind = parent?.getItemAtPosition(position).toString()
                    }
                    else->{
                        kind = parent?.getItemAtPosition(0).toString()
                    }
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        spinnerView.spComponent.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                component = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        spinnerView.bt_cancel.setOnClickListener {
           val arrayList = ArrayList<ObjectData>()
            if (kind == "Xe may"){
                for(i in 1 until xemayCompo.size){
                    arrayList.add(ObjectData(statusOB,et_object_name.text.toString(),kind,xemayCompo[i]))
                }
            }
            Log.d("AAA",arrayList.toString())
        }
        return spinnerView
    }

}