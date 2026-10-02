package com.rieti.app.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.rieti.app.R
import com.rieti.app.viewmodel.SeguimientoViewModel

class SeguimientoActivity : AppCompatActivity() {

    private val viewModel: SeguimientoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seguimiento)

        val isAdmin = intent.getBooleanExtra("isAdmin", false)
        viewModel.cargarCaso(
            intent.getStringExtra("folio") ?: "RIETI-0000",
            intent.getStringExtra("estatus") ?: "Registrado"
        )

        val tvFolio = findViewById<TextView>(R.id.tvFolio)
        val tvEstatus = findViewById<TextView>(R.id.tvEstatusBadge)
        viewModel.folio.observe(this) { tvFolio.text = "#$it" }
        viewModel.estatus.observe(this) { tvEstatus.text = it }

        findViewById<TextView>(R.id.btnBack).setOnClickListener { finish() }

        val tvLectura = findViewById<TextView>(R.id.tvComentarioLectura)
        val etAdmin = findViewById<EditText>(R.id.etComentarioAdmin)
        val btnAccion = findViewById<Button>(R.id.btnAccion)

        // Misma pantalla para los dos roles: solo cambia qué se muestra y qué hace el botón
        if (isAdmin) {
            tvLectura.visibility = View.GONE
            etAdmin.visibility = View.VISIBLE
            btnAccion.text = "Actualizar reporte"
            btnAccion.setOnClickListener {
                val mensaje = viewModel.actualizarReporte(etAdmin.text.toString())
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
            }
        } else {
            tvLectura.visibility = View.VISIBLE
            etAdmin.visibility = View.GONE
            btnAccion.text = "Regresar"
            btnAccion.setOnClickListener { finish() }
        }
    }
}
