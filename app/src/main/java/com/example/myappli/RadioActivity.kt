package com.example.myappli

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RadioActivity : AppCompatActivity() {
    lateinit var radiohasi : RadioButton
    lateinit var radioakat : RadioButton
    lateinit var radiokaguya : RadioButton
    lateinit var ImageViewRadio : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radio)

        radiohasi = findViewById(R.id.btnhasi)
        radioakat = findViewById(R.id.btnakat)
        radiokaguya = findViewById(R.id.btnkaguya)
        ImageViewRadio= findViewById(R.id.imageView4)

        radiohasi.setOnClickListener {
            ImageViewRadio.setImageResource(R.drawable.hasi)
        }
        radioakat.setOnClickListener {
            ImageViewRadio.setImageResource(R.drawable.akat)
        }
        radiokaguya.setOnClickListener {
            ImageViewRadio.setImageResource(R.drawable.kaguya)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.display)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}