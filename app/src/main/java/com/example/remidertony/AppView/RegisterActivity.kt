package com.example.remidertony.AppView

import android.os.Bundle
import com.example.remidertony.BaseActivity
import com.example.remidertony.R

class RegisterActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        super.showFragment(FragmentLogIn())
    }
}