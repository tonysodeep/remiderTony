package com.example.remidertony.AppView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.remidertony.BaseActivity
import com.example.remidertony.R
import kotlinx.android.synthetic.main.fragment_sign_up.view.*

class FragmentSignUp : Fragment() {
    lateinit var showFragment: ShowFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showFragment = activity as BaseActivity
        val view: View = inflater!!.inflate(R.layout.fragment_sign_up,container,false)
        view.bt_back.setOnClickListener {
            showFragment.showFragment(FragmentLogIn())
        }
        return view
    }
}