package com.example.remidertony

import androidx.fragment.app.Fragment

interface ShowFragment {
    fun showFragment(fragment:Fragment)
    fun passData(objectData: ObjectData)
}