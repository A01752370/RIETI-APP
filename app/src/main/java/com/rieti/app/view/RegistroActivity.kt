package com.rieti.app.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.rieti.app.R
import com.rieti.app.viewmodel.RegistroViewModel

class RegistroActivity : AppCompatActivity() {

    private val viewModel: RegistroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        findViewById<Button>(R.id.btnCrearCuenta).setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("isAdmin", false)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.tvYaTengoCuenta).setOnClickListener {
            finish() // regresa a Login
        }

        findViewById<TextView>(R.id.tvAnonimo).setOnClickListener {
            startActivity(Intent(this, FormularioReporteActivity::class.java))
        }
    }
}
