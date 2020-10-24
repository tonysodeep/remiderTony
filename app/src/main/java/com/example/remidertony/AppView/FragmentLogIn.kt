package com.example.remidertony.AppView

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.remidertony.*
import kotlinx.android.synthetic.main.fragment_login.view.*

class FragmentLogIn : Fragment() {
    lateinit var showFragment: ShowFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        showFragment = activity as BaseActivity
        val view : View = inflater!!.inflate(R.layout.fragment_login,container,false)
        view.bt_sign_up.setOnClickListener {
            showFragment.showFragment(FragmentSignUp())
        }
        view.bt_login.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
            (activity as RegisterActivity).finish()
        }
        return view
    }

}