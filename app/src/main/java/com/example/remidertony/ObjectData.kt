package com.example.remidertony

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import android.util.Log

@SuppressLint("ParcelCreator")
class ObjectData : Parcelable {
    var objectName: String = ""
    var objectStatus: String = ""
    var objectKind: String = ""
    var objectComponent: String = ""

    constructor(
        objectName: String,
        objectStatus: String,
        objectKind: String,
        objectComponent: String
    ) {
        this.objectName = objectName
        this.objectStatus = objectStatus
        this.objectKind = objectKind
        this.objectComponent = objectComponent
    }
    constructor()

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {

    }

    fun getInfo() {
        Log.d(
            "aaa",
            this.objectName + " " + this.objectStatus + " " + this.objectKind + " " + this.objectComponent
        )
    }

}