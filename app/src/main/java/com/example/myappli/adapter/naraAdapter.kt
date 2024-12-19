package com.example.myappli.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myappli.R
import org.w3c.dom.NameList

class naraAdapter(
    val context : Context,
    val imageList : ArrayList<Int>,
    val nameList : ArrayList<String>,
    val descList : ArrayList<String>,
    ) : RecyclerView.Adapter<naraAdapter.naraViewHolder>()
{
    class naraViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image : ImageView = itemView.findViewById(R.id.akatImage)
        val title : TextView = itemView.findViewById(R.id.akatsuki)
        val desc : TextView = itemView.findViewById(R.id.Bounty)

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): naraViewHolder {
        val view : view = LayoutInflater.from(context).inflate(R.layout.sample_nara,parent,false)
        return naraViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: naraViewHolder, position: Int) {
        holder.title.text = nameList[position]
        holder.desc.text = descList[position]
        holder.image.setImageResource(imageList[position]) 
    }


}