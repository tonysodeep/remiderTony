package com.example.remidertony

interface ListObject {
    val arrayListObject : ArrayList<ObjectData>
    fun getArrayList():ArrayList<ObjectData>
    fun putObjectArrayList(objectData: ObjectData)
    fun putObject(objectData: ObjectData)
    fun getObject():ArrayList<ObjectData>

}