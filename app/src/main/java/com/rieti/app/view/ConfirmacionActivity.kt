package com.rieti.app.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.rieti.app.R
import com.rieti.app.viewmodel.ConfirmacionViewModel

class ConfirmacionActivity : AppCompatActivity() {

    private val viewModel: ConfirmacionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmacion)

        viewModel.setFolio(intent.getStringExtra("folio") ?: "RIETI-2026-0000")

        // La Activity solo observa: cuando el folio cambia en el ViewModel, actualiza el texto
        viewModel.folio.observe(this) { folio ->
            findViewById<TextView>(R.id.tvFolio).text = "#$folio"
        }

        findViewById<Button>(R.id.btnInicio).setOnClickListener {
            val intent = Intent(this, SplashActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
