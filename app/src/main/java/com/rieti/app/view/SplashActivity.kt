package com.rieti.app.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.rieti.app.R
import com.rieti.app.viewmodel.SplashViewModel

class SplashActivity : AppCompatActivity() {

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val rbAnonimo = findViewById<RadioButton>(R.id.rbAnonimo)
        val rbSeguimiento = findViewById<RadioButton>(R.id.rbSeguimiento)
        val btnContinuar = findViewById<Button>(R.id.btnContinuar)

        rbAnonimo.setOnClickListener { viewModel.seleccionarAnonimo() }
        rbSeguimiento.setOnClickListener { viewModel.seleccionarConSeguimiento() }

        // La Activity solo observa el ViewModel y navega; no decide nada por su cuenta
        btnContinuar.setOnClickListener {
            val esAnonimo = viewModel.esAnonimo.value ?: true
            if (esAnonimo) {
                startActivity(Intent(this, FormularioReporteActivity::class.java))
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
    }
}
