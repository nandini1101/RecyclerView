package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView : RecyclerView
    lateinit var newsArrayList: ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        myRecyclerView = findViewById(R.id.recyclerview)
         val newsImageArray = arrayOf(
             R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,R.drawable.pic6
         )

        val newsHeadingArray = arrayOf(
            "RRR's Naatu Naatu wins Oscars 2023: TV celebs celebrate India's big win at 95th Academy Awards",
            "Oscars 2023: Indian film The Elephant Whisperers wins Academy Award for Best Documentary Short, Guneet Monga reacts",
            "Parliament Budget Session updates | March 14, 2023",
            "PM Modi meets Nokia CEO in Delhi - here's what they discussed",
            "PG medical second year student arrested in Warangal for pushing medico to attempt suicide",
            "Question paper leak: TSPSC to take call on cancellation of exams on Tuesday"
        )

        val newsContent = arrayOf(
            getString(R.string.news_content),getString(R.string.news_content),getString(R.string.news_content),
            getString(R.string.news_content),getString(R.string.news_content),getString(R.string.news_content)
        )

        //to set hav bhav of items inside recyclerview,vertically scrolling,horizontally scrolling,uniform grid
        myRecyclerView.layoutManager =  LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()

        for(i in newsImageArray.indices){
            val news = News(newsHeadingArray[i],newsImageArray[i],newsContent[i])
            newsArrayList.add(news)
        }

        var myAdapter = MyAdapter(newsArrayList , this)
        myRecyclerView.adapter = myAdapter

                                            //down calling interface
        myAdapter.setOnItemClickListener(object : MyAdapter.onItemClicklistener{
            override fun onItemClicking(position: Int){
                //on clicking each item ,what action do you want to perform

                val  intent = Intent(this@MainActivity,Newsdetailactivity::class.java)
                intent.putExtra("heading",newsArrayList[position].newsHeading)
                intent.putExtra("imageId",newsArrayList[position].newsImage)
                intent.putExtra("newscontent",newsArrayList[position].newsContent)
                startActivity(intent)
            }
        })



    }
}