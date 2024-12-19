package com.example.myappli

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class naraActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    val imageList = ArrayList<Int>()
    val nameList = ArrayList<String>()
    val descList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nara)
        recyclerView = findViewById(R.id.recycleView)

        imageList.add(R.drawable.akat)
        imageList.add(R.drawable.hasi)
        imageList.add(R.drawable.kaguya)

        descList.add("Bounty")
        descList.add("FirstHokage")
        descList.add("MotherOfChakra")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recycleView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}