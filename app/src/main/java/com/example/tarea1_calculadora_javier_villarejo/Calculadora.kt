package com.example.tarea1_calculadora_javier_villarejo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_calculadora.*

class Calculadora : AppCompatActivity() {
    private var num1: Int = 0
    private var num2: Int = 0
    private var operacion: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val name: String =intent.getStringExtra("name").toString()
        val surname: String =intent.getStringExtra("surname").toString()

        val textViewName = findViewById<TextView>(R.id.textViewName)

        textViewName.text ="Bienvenido ".toString() + name + " " + surname

        textViewCalc.text = "0"
        operacion = NO_OPERACION

        button1.setOnClickListener{numeroPresionado("1")}
        button2.setOnClickListener{numeroPresionado("2")}
        button3.setOnClickListener{numeroPresionado("3")}
        button4.setOnClickListener{numeroPresionado("4")}
        button5.setOnClickListener{numeroPresionado("5")}
        button6.setOnClickListener{numeroPresionado("6")}
        button7.setOnClickListener{numeroPresionado("7")}
        button8.setOnClickListener{numeroPresionado("8")}
        button9.setOnClickListener{numeroPresionado("9")}
        button0.setOnClickListener{numeroPresionado("0")}

        buttonSum.setOnClickListener{operacionPresionada(SUMA)}
        buttonRest.setOnClickListener{operacionPresionada(RESTA)}
        buttonMulti.setOnClickListener{operacionPresionada(MULTIPLICACION)}
        buttonDiv.setOnClickListener{operacionPresionada(DIVISION)}

        buttonDelete.setOnClickListener{
            num1 = 0
            num2 = 0
            textViewCalc.text = "0"
            operacion = NO_OPERACION
        }

        buttonEquals.setOnClickListener{
            val resultado = when(operacion){
                SUMA -> num1 + num2
                RESTA -> num1 - num2
                MULTIPLICACION -> num1 * num2
                DIVISION -> num1 / num2
                else -> 0
            }

            textViewCalc.text = resultado.toString()
        }
    }

    private fun numeroPresionado(digito: String) {
        if (textViewCalc.text == "0") {
            textViewCalc.text = "$digito"
        } else {
            textViewCalc.text = "${textViewCalc.text}$digito"
        }

        if(operacion == NO_OPERACION){
            num1 = textViewCalc.text.toString().toInt()
        }else {
            num2 = textViewCalc.text.toString().toInt()
        }
    }

    private fun operacionPresionada(operacion: Int) {
        this.operacion = operacion
        num1 = textViewCalc.text.toString().toInt()

        textViewCalc.text = "0"
    }

    companion object {
        const val SUMA = 1
        const val  RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val NO_OPERACION = 0
    }
}