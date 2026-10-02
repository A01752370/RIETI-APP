package com.rieti.app.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.rieti.app.R
import com.rieti.app.viewmodel.FormularioReporteViewModel

class FormularioReporteActivity : AppCompatActivity() {

    private val viewModel: FormularioReporteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_reporte)

        findViewById<TextView>(R.id.btnBack).setOnClickListener { finish() }

        findViewById<TextView>(R.id.btnSubirFoto).setOnClickListener {
            Toast.makeText(this, "Función no disponible en este avance", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btnEnviarReporte).setOnClickListener {
            val folio = viewModel.generarFolio()
            val intent = Intent(this, ConfirmacionActivity::class.java)
            intent.putExtra("folio", folio)
            startActivity(intent)
        }
    }
}
