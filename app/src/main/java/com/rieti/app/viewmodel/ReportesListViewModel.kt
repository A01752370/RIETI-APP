package com.rieti.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rieti.app.model.Reporte

class ReportesListViewModel : ViewModel() {

    private val _reportes = MutableLiveData<List<Reporte>>()
    val reportes: LiveData<List<Reporte>> = _reportes

    init {
        // Datos fijos de ejemplo (sin base de datos todavía), igual que el mockup de Figma
        _reportes.value = listOf(
            Reporte("RIETI-0001", "Registrado", "Hoy, 14:32"),
            Reporte("RIETI-0002", "En Revisión", "15 Ago 2024"),
            Reporte("RIETI-0003", "En Seguimiento", "10 Ago 2024"),
            Reporte("RIETI-0004", "Concluido", "10 Ago 2024"),
            Reporte("RIETI-0005", "Canalizado", "10 Ago 2024")
        )
    }
}
