package com.example.manzanaverde

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var loginButton: Button
    private lateinit var rememberMeCheckBox: CheckBox

    private val validEmail = "ejemplo@idat.edu.pe"
    private val validPassword = "123456"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailEditText = findViewById(R.id.tietCorreo)
        passwordEditText = findViewById(R.id.tietClave)
        loginButton = findViewById(R.id.btnLogin)
        rememberMeCheckBox = findViewById(R.id.chkPromociones)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (email == validEmail && password == validPassword) {
                // Inicio de sesión exitoso
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, InicioActivity::class.java )
                startActivity(intent)
                finish()
                // Aquí puedes agregar la lógica para abrir la siguiente actividad o realizar otras acciones
            } else {
                // Credenciales inválidas
                Toast.makeText(this, "Credenciales inválidas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
