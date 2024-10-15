package com.example.pmdm.ejercicio1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pmdm.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainejer_1)

        // Referencias a los elementos del layout
        val editTextUrl = findViewById<EditText>(R.id.editTextUrl)
        val btnOpenUrl = findViewById<Button>(R.id.btnOpenUrl)

        // Acción al pulsar el botón
        btnOpenUrl.setOnClickListener {
            val url = editTextUrl.text.toString().trim()

            // Comprobar que el campo no esté vacío y que sea una URL válida
            if (url.isEmpty()) {
                Toast.makeText(this, "Por favor, introduce una URL.", Toast.LENGTH_SHORT).show()
            } else if (!isValidUrl(url)) {
                Toast.makeText(this, "Introduce una URL válida.", Toast.LENGTH_SHORT).show()
            } else {
                // Si la URL es válida, abrirla en el navegador
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }
        }
    }

    // Función para validar si es una URL correcta
    private fun isValidUrl(url: String): Boolean {
        return Patterns.WEB_URL.matcher(url).matches()
    }
}
