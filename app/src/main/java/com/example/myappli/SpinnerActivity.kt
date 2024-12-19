package com.example.myappli

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class SpinnerActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var spinnerActivity: Spinner
    lateinit var textView: TextView
    lateinit var autoCompleteTextView: AutoCompleteTextView
    lateinit var date : EditText

    val countries = arrayOf("Nepal", "USA", "China", "Australia", "Canada", "Somalia")
    val city = arrayOf("Kathmandu", "Kirtipur", "Kanchanpur", "Bhaktapur", "Kailali", "Kakadvitta", "koshiBarrage")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spinner)
        spinnerActivity = findViewById(R.id.spinner)
        textView = findViewById(R.id.textView9)
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView)
        date = findViewById(R.id.Date)

        date.isFocusable = false
        date.isClickable = true
        date.setOnClickListener {
            loadcalender()
        }

        var autoAdapter = ArrayAdapter(
            this@SpinnerActivity,
            android.R.layout.simple_dropdown_item_1line,
            city
        )
//        recommend after how many letter ?
        autoCompleteTextView.setAdapter(autoAdapter)
        autoCompleteTextView.threshold = 1

        val adapter = ArrayAdapter(
            this@SpinnerActivity,
            android.R.layout.simple_spinner_item,
            countries
        )
//        keep gap in drop down
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item,
        )
        spinnerActivity.adapter = adapter
        spinnerActivity.onItemSelectedListener = this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recycleView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loadcalender() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val days = c.get(Calendar.DAY_OF_MONTH)

        val dialog = DatePickerDialog(
            this@SpinnerActivity,
            DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                date.setText("$year/${month+1}/$day")
            }, year, month, days
        )
        dialog.show()
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if(p0 != null){
            textView.text = p0.getItemAtPosition(p2).toString()
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}