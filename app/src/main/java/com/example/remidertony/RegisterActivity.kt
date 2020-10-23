package com.example.remidertony

import android.os.Bundle

class RegisterActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        super.showFragment(FragmentLogIn())
    }
}