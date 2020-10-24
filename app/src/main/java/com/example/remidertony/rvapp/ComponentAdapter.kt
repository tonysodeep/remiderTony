package com.example.remidertony.rvapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.remidertony.R

class ComponentAdapter(private val context: Context, private val compoList: List<ComponentData>) :
    RecyclerView.Adapter<ComponentAdapter.CompoViewHolder>() {
    class CompoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var compoName : TextView? = null
        var compoDate : TextView? = null
        init {
            compoName = itemView.findViewById(R.id.compo_name)
            compoDate = itemView.findViewById(R.id.compo_date)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompoViewHolder {
        return CompoViewHolder(LayoutInflater.from(context).inflate(R.layout.item_compo_layout,parent,false))
    }

    override fun onBindViewHolder(holder: CompoViewHolder, position: Int) {
        holder.compoName!!.text = compoList[position].compoName
        holder.compoDate!!.text = compoList[position].compoDate
    }

    override fun getItemCount(): Int {
        return compoList.size
    }
}