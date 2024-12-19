package com.example.myappli

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class interactionActivity : AppCompatActivity() {
    lateinit var btnToast : Button
    lateinit var btnSnack : Button
    lateinit var btnAlert : Button
    lateinit var main: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_interaction)

        main=findViewById(R.id.recycleView)
        btnToast = findViewById(R.id.toast)
        btnSnack = findViewById(R.id.snackbar)
        btnAlert = findViewById(R.id.alert)

        btnToast.setOnClickListener {
            Toast.makeText( this@interactionActivity,
                "LOGIN SUCCESS", Toast.LENGTH_LONG).show()
        }

        btnSnack.setOnClickListener {
            Snackbar.make(main,
                "Invalid Login",
                Snackbar.LENGTH_LONG
            ).setAction("CLOSE", {}).show()
        }

        btnAlert.setOnClickListener {
            var alert = AlertDialog.Builder(this@interactionActivity)
            alert.setTitle("Confirmation")
                .setMessage("Are you sure ?")
                .setIcon(R.drawable.kaguya)
                .setNegativeButton("NO", DialogInterface.OnClickListener
                { dialogInterface, i ->
                    dialogInterface.dismiss()
                })
                .setPositiveButton("YES", DialogInterface.OnClickListener
                { dialogInterface, i ->

                })

            alert.create().show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recycleView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}