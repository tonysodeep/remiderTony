package com.example.remidertony.Database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast

val DATABASE_NAME = "MyDB"
val TABLE_USER_NAME = "User"
val TABLE_OBJECT = "Object"
val COL_USER_ID = "Id"
val COL_ACCOUNT_NAME = "Account_Name"
val COL_ACCOUNT_PASSWORD = "Account_Password"
val COL_ACCOUNT_EMAIL = "Account_Email"
val COL_OBJECT_ID = "Object_ID"
val COL_OBJECT_NAME = "Object_Name"
val COL_OBJECT_STATUS = "Object_Status"
val COL_OBJECT_KIND = "Object_Kind"
val COL_OBJECT_COMPONENT = "Object_Component"

class AppDataBase(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createUserTable =
            "CREATE TABLE $TABLE_USER_NAME ($COL_USER_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COL_ACCOUNT_NAME TEXT, $COL_ACCOUNT_PASSWORD TEXT, $COL_ACCOUNT_EMAIL TEXT )"
        val createObjectTable =
            "CREATE TABLE $TABLE_OBJECT ($COL_OBJECT_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COL_OBJECT_STATUS TEXT, $COL_OBJECT_NAME TEXT, $COL_OBJECT_KIND TEXT, $COL_OBJECT_COMPONENT TEXT )"
        db?.execSQL(createUserTable)
        db?.execSQL(createObjectTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
//    fun insertData(objectData: ObjectData){
//        val db = this.writableDatabase
//        var cv = ContentValues()
//        cv.apply {
//            put(COL_OBJECT_STATUS,objectData.objectStatus)
//            put(COL_OBJECT_NAME,objectData.objectName)
//            put(COL_OBJECT_KIND,objectData.objectKind)
//            put(COL_OBJECT_COMPONENT,objectData.objectComponent)
//        }
//        var result = db.insert(TABLE_OBJECT, null, cv)
//        if (result == (-1).toLong()) {
//            Toast.makeText(context, "Fail", Toast.LENGTH_LONG).show()
//            Log.d("result", result.toString())
//        } else {
//            Toast.makeText(context, "Success", Toast.LENGTH_LONG).show()
//            Log.d("result", result.toString())
//        }
//    }
//    fun readData():ArrayList<ObjectData>{
//        val list : ArrayList<ObjectData> = ArrayList()
//        val db = this.readableDatabase
//        val query = "SELECT * FROM $TABLE_OBJECT"
//        val result = db.rawQuery(query, null)
//        if (result.moveToFirst()) {
//            do {
//                var objectData = ObjectData()
//                objectData.apply {
//                    objectName = result.getString(result.getColumnIndex(COL_OBJECT_NAME))
//                    objectStatus = result.getString(result.getColumnIndex(COL_OBJECT_STATUS))
//                    objectKind = result.getString(result.getColumnIndex(COL_OBJECT_KIND))
//                    objectComponent = result.getString(result.getColumnIndex(COL_OBJECT_COMPONENT))
//                    list.add(objectData)
//                }
//            } while (result.moveToNext())
//        }
//        result.close()
//        db.close()
//        return list
//    }

}