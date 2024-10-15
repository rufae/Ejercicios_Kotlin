package com.example.pmdm.ejercicio2

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.example.pmdm.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainejer_2)

        // Referencia al botón
        val btnNavigate = findViewById<Button>(R.id.btnNavigate)

        // Configurar el listener del botón
        btnNavigate.setOnClickListener {
            // Crear un Intent para el SecondActivity
            val intent = Intent(this, SecondActivity::class.java)

            // Crear un PendingIntent para la navegación
            val pendingIntent = PendingIntent.getActivity(
                this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

            // Usar Handler para retrasar la ejecución del PendingIntent por 10 segundos
            Handler(Looper.getMainLooper()).postDelayed({
                try {
                    // Lanzar el PendingIntent para iniciar el SecondActivity
                    pendingIntent.send()
                } catch (e: PendingIntent.CanceledException) {
                    e.printStackTrace()
                }
            }, 10000) // 10000 milisegundos = 10 segundos
        }
    }
}
