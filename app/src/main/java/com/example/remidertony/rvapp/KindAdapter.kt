package com.example.remidertony.rvapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.remidertony.R

class KindAdapter(private val context: Context, private val listKind: List<KindData>) :
    RecyclerView.Adapter<KindAdapter.KindViewHolder>(){
    class KindViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var kindTitle: TextView = itemView.findViewById(R.id.tv_kind)
        var compoRecycleView: RecyclerView = itemView.findViewById(R.id.rv_compo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KindViewHolder {
        return KindViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_kind_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: KindViewHolder, position: Int) {
        holder.kindTitle.text = listKind[position].kind
        setKindItemRecycle(holder.compoRecycleView,listKind[position].kindCompoList)
    }

    override fun getItemCount(): Int {
        return listKind.size
    }
    private fun setKindItemRecycle(recyclerView: RecyclerView,kindItem:List<ComponentData>){
        val compoRecyclerAdapter = ComponentAdapter(context,kindItem)
        recyclerView.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        recyclerView.adapter = compoRecyclerAdapter
    }
}