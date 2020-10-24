package com.example.remidertony

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.remidertony.AppView.ShowFragment
import kotlinx.android.synthetic.main.fragment_add_item.*
import kotlinx.android.synthetic.main.fragment_add_item.view.*

class FragmentAddItem : Fragment() {

    private lateinit var showFragment : ShowFragment
    private lateinit var listObject: ListObject
    var name : String = ""
    var kind : String = ""
    var component : String = ""
    var statusOB : String = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_add_item, container, false)
        //arr => status, kind, component, none
        val kinds = resources.getStringArray(R.array.objectKind)
        val componentXeMay = resources.getStringArray(R.array.xemayComponent)
        val componentTuLanh = resources.getStringArray(R.array.tuLanhComponent)
        val componentMayLanh = resources.getStringArray(R.array.mayLanhComponent)
        val status = resources.getStringArray(R.array.status)
        val none = resources.getStringArray(R.array.noneArray)

        //spinner => status - kind - component
        val spinnerStatus = view.findViewById<Spinner>(R.id.spStatus)
        val spinnerKind = view.findViewById<Spinner>(R.id.spKind)
        val spinnerComponent = view.findViewById<Spinner>(R.id.spComponent)

        showFragment = activity as BaseActivity
        listObject = activity as MainActivity

        val arrayAdapterStatus = ArrayAdapter(
            activity as MainActivity, android.R.layout.simple_spinner_item, status
        )
        spinnerStatus.adapter = arrayAdapterStatus

        val arrayAdapterKind = ArrayAdapter(
            activity as MainActivity, android.R.layout.simple_spinner_item,none
        )
        spinnerKind.adapter = arrayAdapterKind

        val arrayAdapterComponent = ArrayAdapter(
            activity as MainActivity, android.R.layout.simple_spinner_item,none
        )
        spinnerComponent.adapter = arrayAdapterComponent


        spinnerStatus.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if(position == 1){
                    val arrayAdapterKinds = ArrayAdapter(
                        activity as MainActivity, android.R.layout.simple_spinner_item,
                        kinds
                    )
                    spinnerKind.adapter = arrayAdapterKinds

                    spinnerComponent.visibility = View.GONE
                }
                if(position == 2){
                    val arrayAdapterKinds = ArrayAdapter(
                        activity as MainActivity, android.R.layout.simple_spinner_item,
                        kinds
                    )
                    statusOB =  status[position]
                    spinnerKind.adapter = arrayAdapterKinds
                    spinnerComponent.visibility = View.VISIBLE
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerKind.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if(position == 1){
                    val arrayAdapterComponents = ArrayAdapter(
                        activity as MainActivity, android.R.layout.simple_spinner_item,
                        componentXeMay
                    )
                    kind = kinds[position]
                    component = componentXeMay[position]
                    spinnerComponent.adapter = arrayAdapterComponents
                }
                if(position == 2){
                    val arrayAdapterComponents = ArrayAdapter(
                        activity as MainActivity, android.R.layout.simple_spinner_item,
                        componentMayLanh
                    )
                    kind = kinds[position]
                    component = componentMayLanh[position]
                    spinnerComponent.adapter = arrayAdapterComponents

                }
                if(position == 3){
                    val arrayAdapterComponents = ArrayAdapter(
                        activity as MainActivity, android.R.layout.simple_spinner_item,
                        componentTuLanh
                    )
                    kind = kinds[position]
                    component = componentTuLanh[position]
                    spinnerComponent.adapter = arrayAdapterComponents
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }



        view.bt_cancel.setOnClickListener {
            showFragment.showFragment(FragmentFullItem())
        }
        return view
    }

}