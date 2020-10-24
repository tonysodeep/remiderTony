package com.example.remidertony

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.remidertony.AppView.ShowFragment

open class BaseActivity : AppCompatActivity(), ShowFragment {

    override fun showFragment(fragment: Fragment) {
        val transition = supportFragmentManager.beginTransaction()
        transition.replace(R.id.box_fragment_holder, fragment)
        transition.addToBackStack(null)
        transition.commit()
    }




}