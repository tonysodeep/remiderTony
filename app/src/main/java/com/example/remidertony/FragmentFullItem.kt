package com.example.remidertony

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_full_list_item.view.*

class FragmentFullItem : Fragment() {
    lateinit var showFragment: ShowFragment
    lateinit var objectAdapter: ObjectAdapter
    private lateinit var listObject: ListObject

    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_full_list_item, container, false)
        //floating button

        view.fb_say_hello.setOnClickListener {
            Toast.makeText(activity as MainActivity,"hello world",Toast.LENGTH_LONG).show()
        }
        view.fb_add_item.setOnClickListener {
            showFragment.showFragment(FragmentAddItem())
        }
        view.draft.setOnClickListener {
            showFragment.showFragment(DrafFragment())
        }

        showFragment = activity as BaseActivity
        listObject = activity as MainActivity
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_list_item)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = linearLayoutManager
        objectAdapter = ObjectAdapter(listObject.getObject(), activity as MainActivity)
        recyclerView.adapter = objectAdapter

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


}