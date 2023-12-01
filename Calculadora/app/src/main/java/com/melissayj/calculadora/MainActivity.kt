package com.melissayj.calculadora

// Importamos las librerías necesarias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

// Declaramos las variables que vamos a utilizar
    private var num1: Float = 0.0f
    private var num2: Float = 0.0f
    private var isOpPressed: Boolean = false
    private var op: Char = ' '

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Asignamos los botones a las variables
        val oneBtn = findViewById<Button>(R.id.oneBtn)
        val twoBtn = findViewById<Button>(R.id.twoBtn)
        val threeBtn = findViewById<Button>(R.id.threeBtn)
        val fourBtn = findViewById<Button>(R.id.fourBtn)
        val fiveBtn = findViewById<Button>(R.id.fiveBtn)
        val sixBtn = findViewById<Button>(R.id.sixBtn)
        val sevenBtn = findViewById<Button>(R.id.sevenBtn)
        val eightBtn = findViewById<Button>(R.id.eightBtn)
        val nineBtn = findViewById<Button>(R.id.nineBtn)
        val zeroBtn = findViewById<Button>(R.id.zeroBtn)
        val dotBtn = findViewById<Button>(R.id.dotBtn)
        val equalBtn = findViewById<Button>(R.id.equalBtn)
        val addBtn = findViewById<Button>(R.id.addBtn)
        val subBtn = findViewById<Button>(R.id.subBtn)
        val mulBtn = findViewById<Button>(R.id.mulBtn)
        val divBtn = findViewById<Button>(R.id.divBtn)
        val clearBtn = findViewById<Button>(R.id.clearBtn)
        val result = findViewById<TextView>(R.id.result)

        // Asignamos las acciones a los botones
        oneBtn.setOnClickListener { numberClicked(1) }
        twoBtn.setOnClickListener { numberClicked(2) }
        threeBtn.setOnClickListener { numberClicked(3) }
        fourBtn.setOnClickListener { numberClicked(4) }
        fiveBtn.setOnClickListener { numberClicked(5) }
        sixBtn.setOnClickListener { numberClicked(6) }
        sevenBtn.setOnClickListener { numberClicked(7) }
        eightBtn.setOnClickListener { numberClicked(8) }
        nineBtn.setOnClickListener { numberClicked(9) }
        zeroBtn.setOnClickListener { numberClicked(0) }
        dotBtn.setOnClickListener { dotClicked() }

        // Asignamos las operaciones a los botones
        addBtn.setOnClickListener { operationClicked('+') }
        subBtn.setOnClickListener { operationClicked('-') }
        mulBtn.setOnClickListener { operationClicked('*') }
        divBtn.setOnClickListener { operationClicked('/') }

        // Asignamos la acción al botón de igual
        equalBtn.setOnClickListener { equalsClicked() }

        // Asignamos la acción al botón de limpiar
        clearBtn.setOnClickListener { clearClicked() }
    }

    // Función que se ejecuta cuando se presiona un número
    private fun numberClicked(num: Int) {
        if (isOpPressed) {
            if (op == '/' && num == 0) {
                result.text = "Error"
            } else {
                num2 = num.toFloat()
                result.text = num2.toString()
                isOpPressed = false
            }
        } else {
            val number = result.text.toString() + num.toString()
            result.text = number
            num1 = number.toFloat()
        }
    }

    // Función que se ejecuta cuando se presiona el botón de punto
    private fun dotClicked() {
        if (!result.text.toString().contains('.')) {
            result.text = result.text.toString() + "."
        }
    }

    // Función que se ejecuta cuando se presiona una operación
    private fun operationClicked(operation: Char) {
        op = operation
        isOpPressed = true
    }

    // Función que se ejecuta cuando se presiona el botón de igual
    private fun equalsClicked() {
        when (op) {
            '+' -> result.text = (num1 + num2).toString()
            '-' -> result.text = (num1 - num2).toString()
            '*' -> result.text = (num1 * num2).toString()
            '/' -> result.text = (num1 / num2).toString()
        }
    }

    // Función que se ejecuta cuando se presiona el botón de limpiar
    private fun clearClicked() {
        result.text = ""
        num1 = 0.0f
        num2 = 0.0f
        isOpPressed = false
    }
}