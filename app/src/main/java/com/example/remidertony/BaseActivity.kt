package com.example.remidertony

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import java.io.Serializable

open class BaseActivity : AppCompatActivity(),ShowFragment {

    override fun showFragment(fragment: Fragment) {
        val transition = supportFragmentManager.beginTransaction()
        transition.replace(R.id.box_fragment_holder, fragment)
        transition.addToBackStack(null)
        transition.commit()
    }

    override fun passData(objectData: ObjectData) {
        val bundle = Bundle()
        bundle.putParcelable("objectData",objectData)
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentMain = FragmentFullItem()
        fragmentMain.arguments = bundle
        transaction.replace(R.id.box_fragment_holder,fragmentMain)
        transaction.commit()
    }
}