package com.example.pmdm.ejercicio3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.pmdm.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainejer_3)

        // Referencias a los botones
        val buttonFirst = findViewById<Button>(R.id.buttonFirst)
        val buttonSecond = findViewById<Button>(R.id.buttonSecond)
        val buttonThird = findViewById<Button>(R.id.buttonThird)

        // Configurar el listener para cada botón
        buttonFirst.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }

        buttonSecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        buttonThird.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }

}