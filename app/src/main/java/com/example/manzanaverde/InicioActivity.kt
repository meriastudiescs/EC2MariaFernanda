package com.example.manzanaverde

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.widget.Button

class InicioActivity : AppCompatActivity() {

    private lateinit var btnMapa: Button
    private lateinit var btnCamara: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        btnMapa = findViewById(R.id.btnMapa)
        btnCamara = findViewById(R.id.btnCamara)

        btnMapa.setOnClickListener {
            val intent = Intent(this, MapaActivity::class.java)
            startActivity(intent)
        }

        btnCamara.setOnClickListener {
            val intent = Intent(this, CamaraActivity::class.java)
            startActivity(intent)
        }
    }
}
