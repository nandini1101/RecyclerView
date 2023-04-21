package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Newsdetailactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newsdetailactivity)


        val heading = intent.getStringExtra("heading")
        val newsContent = intent.getStringExtra("newscontent")
        val imageId = intent.getIntExtra("imageId",R.drawable.pic1)


        val headingTv = findViewById<TextView>(R.id.textView)
        val headingIv = findViewById<ImageView>(R.id.imageView)
        val newsContentTv = findViewById<TextView>(R.id.newsContent)

        headingTv.text= heading
        newsContentTv.text=newsContent
        headingIv.setImageResource(imageId)
    }
}