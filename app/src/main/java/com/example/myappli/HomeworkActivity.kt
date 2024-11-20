package com.example.myappli

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeworkActivity : AppCompatActivity() {
    lateinit var TT1: TextView
    lateinit var TT2: TextView
    lateinit var EE1: EditText
    lateinit var EE2: EditText
    lateinit var EE3: EditText
    lateinit var EE4: EditText

    lateinit var BB1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_homework2)
        TT1 =findViewById(R.id.fries)
        TT2 =findViewById(R.id.free)
        EE1 =findViewById(R.id.fname)
        EE2 =findViewById(R.id.lname)
        EE3 =findViewById(R.id.mail)
        EE4 =findViewById(R.id.pass)
        BB1 =findViewById(R.id.signup)




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}