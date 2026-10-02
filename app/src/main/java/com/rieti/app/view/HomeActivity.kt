package com.rieti.app.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.rieti.app.R
import com.rieti.app.viewmodel.HomeViewModel

class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModels()
    private var isAdmin = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        isAdmin = intent.getBooleanExtra("isAdmin", false)
        viewModel.cargarDatos(isAdmin)

        val tvTitulo = findViewById<TextView>(R.id.tvTituloReportes)
        val tvTotal = findViewById<TextView>(R.id.tvTotalReportes)

        // La Activity solo observa: se actualiza sola cuando cambian los datos del ViewModel
        viewModel.tituloTarjeta.observe(this) { tvTitulo.text = it }
        viewModel.totalReportes.observe(this) { tvTotal.text = it }

        findViewById<Button>(R.id.btnHacerReporte).setOnClickListener {
            startActivity(Intent(this, FormularioReporteActivity::class.java))
        }

        findViewById<TextView>(R.id.tabCasos).setOnClickListener {
            val intent = Intent(this, ReportesListActivity::class.java)
            intent.putExtra("isAdmin", isAdmin)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.tabPerfil).setOnClickListener {
            Toast.makeText(this, "Perfil no incluido en este avance", Toast.LENGTH_SHORT).show()
        }
    }
}
