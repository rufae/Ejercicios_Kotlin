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

        val btnActivity1 = findViewById<Button>(R.id.btnActivity1)
        val btnActivity2 = findViewById<Button>(R.id.btnActivity2)
        val btnActivity3 = findViewById<Button>(R.id.btnActivity3)

        btnActivity1.setOnClickListener {
            startActivity(Intent(this, FirstActivity::class.java))
        }

        btnActivity2.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        btnActivity3.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }
    }
}
