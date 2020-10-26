package com.example.remidertony

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.remidertony.AppView.DrafFragment
import com.example.remidertony.AppView.ShowFragment
import com.example.remidertony.rvapp.ComponentData
import com.example.remidertony.rvapp.KindAdapter
import com.example.remidertony.rvapp.KindData
import kotlinx.android.synthetic.main.fragment_full_list_item.view.*
import java.util.ArrayList

class FragmentFullItem : Fragment() {
    lateinit var showFragment: ShowFragment
    private var mainKindRV : RecyclerView? = null
    private var kindAdapter : KindAdapter? = null
    lateinit var viewLayout : View
    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showFragment = activity as BaseActivity
        viewLayout = inflater!!.inflate(R.layout.fragment_full_list_item, container, false)
        //floating button

        viewLayout.fb_say_hello.setOnClickListener {
            Toast.makeText(activity as MainActivity,"hello world",Toast.LENGTH_LONG).show()
        }
        viewLayout.fb_add_item.setOnClickListener {
            showFragment.showFragment(FragmentAddItem())
        }
        viewLayout.draft.setOnClickListener {
            showFragment.showFragment(DrafFragment())
        }
        val itemList:MutableList<ComponentData> = ArrayList()
        itemList.add(ComponentData("nhot xe","05/02/2020"))
        itemList.add(ComponentData("vo banh","05/02/2020"))
        itemList.add(ComponentData("nhot xe","05/02/2020"))
        val itemList2:MutableList<ComponentData> = ArrayList()
        itemList2.add(ComponentData("gas","05/02/2020"))
        itemList2.add(ComponentData("cua","05/02/2020"))
        itemList2.add(ComponentData("nhot xe","05/02/2020"))
        itemList2.add(ComponentData("nhot xe","05/02/2020"))
        val allKind : MutableList<KindData> = ArrayList()
        allKind.add(KindData("xe may",itemList))
        allKind.add(KindData("tu lanh",itemList2))
        setKindAdapter(allKind)
        return viewLayout
    }
    private fun setKindAdapter(allKind : List<KindData>){
        mainKindRV = viewLayout?.findViewById(R.id.rv_list_item)
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity as MainActivity)
        mainKindRV!!.layoutManager = layoutManager
        kindAdapter  = KindAdapter(activity as MainActivity,allKind)
        mainKindRV!!.adapter = kindAdapter
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


}