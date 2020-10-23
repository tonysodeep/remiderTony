package com.example.remidertony

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.single_item_display.view.*


class ObjectAdapter(private val objectList: ArrayList<ObjectData>, private val context: Context) :
    RecyclerView.Adapter<ObjectAdapter.ObjectViewHolder>() {
    class ObjectViewHolder(objectView: View) : RecyclerView.ViewHolder(objectView) {
        val objectName : TextView = objectView.tv_ob_name
        val objectStatus : TextView = objectView.tv_ob_status
        val objectKind : TextView = objectView.tv_ob_kind
        val objectComponent : TextView = objectView.tv_ob_component
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectViewHolder {
        var objectView =
            LayoutInflater.from(parent.context).inflate(R.layout.single_item_display,parent,false)
        return ObjectViewHolder(objectView)
    }

    override fun onBindViewHolder(holder: ObjectViewHolder, position: Int) {
        val currentItem = objectList[position]
        holder.objectName.text = currentItem.objectName
        holder.objectStatus.text = currentItem.objectStatus
        holder.objectKind.text = currentItem.objectKind
        holder.objectComponent.text = currentItem.objectComponent
    }

    override fun getItemCount(): Int {
        return objectList.size
    }
    fun addItem(objectData: ObjectData) {
        objectList.add(objectData)
        notifyDataSetChanged()
    }
}