package com.example.remidertony

import android.os.Bundle
import com.example.remidertony.Database.AppDataBase

class MainActivity : BaseActivity(),ListObject {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        super.showFragment(FragmentFullItem())
    }
}