package com.rieti.app.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.rieti.app.R
import com.rieti.app.model.Reporte
import com.rieti.app.viewmodel.ReportesListViewModel

class ReportesListActivity : AppCompatActivity() {

    private val viewModel: ReportesListViewModel by viewModels()
    private var isAdmin = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reportes_list)

        isAdmin = intent.getBooleanExtra("isAdmin", false)

        val contenedor = findViewById<LinearLayout>(R.id.contenedorReportes)
        val inflater = LayoutInflater.from(this)

        // La Activity solo pinta lo que el ViewModel le entrega, no arma los datos ella misma
        viewModel.reportes.observe(this) { lista ->
            contenedor.removeAllViews()
            for (reporte in lista) {
                val item = inflater.inflate(R.layout.item_reporte, contenedor, false)
                item.findViewById<TextView>(R.id.tvFolioItem).text = "#${reporte.folio}"
                item.findViewById<TextView>(R.id.tvEstatusItem).text = reporte.estatus
                item.findViewById<TextView>(R.id.tvFechaItem).text = "🕒 ${reporte.fecha}"

                item.setOnClickListener {
                    val intent = Intent(this, SeguimientoActivity::class.java)
                    intent.putExtra("isAdmin", isAdmin)
                    intent.putExtra("folio", reporte.folio)
                    intent.putExtra("estatus", reporte.estatus)
                    startActivity(intent)
                }
                contenedor.addView(item)
            }
        }

        findViewById<Button>(R.id.btnHacerReporte).setOnClickListener {
            startActivity(Intent(this, FormularioReporteActivity::class.java))
        }

        findViewById<TextView>(R.id.tabPerfil).setOnClickListener {
            Toast.makeText(this, "Perfil no incluido en este avance", Toast.LENGTH_SHORT).show()
        }
    }
}
