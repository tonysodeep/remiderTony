package com.example.remidertony

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),ListObject {

    override var arrayListObject: ArrayList<ObjectData> = ArrayList()
    lateinit var dataBase: AppDataBase

    override fun getArrayList(): ArrayList<ObjectData> {
        return arrayListObject
    }
    override fun putObjectArrayList(objectData: ObjectData) {
        arrayListObject.add(objectData)
    }
    //DataBase

    override fun putObject(objectData: ObjectData) {
        dataBase.insertData(objectData)
    }

    override fun getObject(): ArrayList<ObjectData> {
        return dataBase.readData()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        super.showFragment(FragmentFullItem())
        dataBase = AppDataBase(this)

    }
}