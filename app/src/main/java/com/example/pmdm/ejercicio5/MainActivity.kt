package com.example.pmdm.ejercicio5

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pmdm.R

class MainActivity : AppCompatActivity() {

    private lateinit var tvDisplay: TextView
    private var currentNumber: String = ""
    private var firstNumber: Double = 0.0
    private var operation: String? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainejer_5)

        tvDisplay = findViewById(R.id.tvDisplay)

        val buttons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btnDecimal, R.id.btnAdd, R.id.btnSubtract,
            R.id.btnMultiply, R.id.btnDivide, R.id.btnEqual, R.id.btnClear
        )

        buttons.forEach { id ->
            findViewById<Button>(id).setOnClickListener { onButtonClick(it) }
        }
    }

    private fun onButtonClick(view: View) {
        val button = view as Button
        val value = button.text.toString()

        when (value) {
            "C" -> {
                currentNumber = ""
                firstNumber = 0.0
                operation = null
                tvDisplay.text = "0"
            }
            "=" -> {
                if (operation != null) {
                    val secondNumber = currentNumber.toDoubleOrNull() ?: 0.0
                    val result = when (operation) {
                        "+" -> firstNumber + secondNumber
                        "-" -> firstNumber - secondNumber
                        "*" -> firstNumber * secondNumber
                        "/" -> if (secondNumber != 0.0) firstNumber / secondNumber else "Error"
                        else -> "Error"
                    }
                    tvDisplay.text = result.toString()
                    currentNumber = result.toString()
                    operation = null
                }
            }
            "+", "-", "*", "/" -> {
                firstNumber = currentNumber.toDoubleOrNull() ?: 0.0
                operation = value
                currentNumber = ""
            }
            else -> {
                currentNumber += value
                tvDisplay.text = currentNumber
            }
        }
    }
}
