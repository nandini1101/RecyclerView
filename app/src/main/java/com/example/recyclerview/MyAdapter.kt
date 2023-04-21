package com.example.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityManager.AccessibilityServicesStateChangeListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import java.math.MathContext

class MyAdapter(var newsArrayList: ArrayList<News> , var context: Activity) :
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private lateinit var myListener: onItemClicklistener

    interface onItemClicklistener{

        fun onItemClicking(position: Int)

    }

    fun setOnItemClickListener(listener : onItemClicklistener){
        myListener = listener
    }

    // to create new view instance
    // when layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.eachitem,parent,false)
        return MyViewHolder(itemView,myListener)
    }

    //populate items with data
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        var currentItem = newsArrayList[position]
        holder.hTitle.text = currentItem.newsHeading
        holder.hImage.setImageResource(currentItem.newsImage)
    }



    //how many list items are present in your array
    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    //it holds the view so views are not created everytime , so memory can be saved
    class MyViewHolder(itemView : View , listener: onItemClicklistener) : RecyclerView.ViewHolder(itemView) {
        val hTitle = itemView.findViewById<TextView>(R.id.HeadingTitle)
        val hImage = itemView.findViewById<ShapeableImageView>(R.id.headingImage)

        //init is a keyword works as constructor to initialise variables in kotlin
        init{
            itemView.setOnClickListener{
                listener.onItemClicking(adapterPosition)
            }
        }
    }


}