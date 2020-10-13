package com.example.tarea1_calculadora_javier_villarejo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun access (view: View){

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextSurname = findViewById<EditText>(R.id.editTextSurname)

        val name:String = editTextName.text.toString()
        val surname:String = editTextSurname.text.toString()

        if (name != null || surname != null) {
            val miIntent = Intent(this, Calculadora::class.java)

            miIntent.putExtra("name", name)
            miIntent.putExtra("surname",surname)

            startActivity(miIntent)
        }
    }
}