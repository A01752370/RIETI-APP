package com.rieti.app.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.rieti.app.R
import com.rieti.app.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etCorreo = findViewById<EditText>(R.id.etCorreo)

        findViewById<Button>(R.id.btnIniciarSesion).setOnClickListener {
            val esAdmin = viewModel.esAdmin(etCorreo.text.toString())
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("isAdmin", esAdmin)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.tvCrearCuenta).setOnClickListener {
            startActivity(Intent(this, RegistroActivity::class.java))
        }

        findViewById<TextView>(R.id.tvAnonimo).setOnClickListener {
            startActivity(Intent(this, FormularioReporteActivity::class.java))
        }
    }
}
