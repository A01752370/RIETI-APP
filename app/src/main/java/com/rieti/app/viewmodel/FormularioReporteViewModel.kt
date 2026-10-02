package com.rieti.app.viewmodel

import androidx.lifecycle.ViewModel

class FormularioReporteViewModel : ViewModel() {

    // Genera un folio de ejemplo para la demo (todavía no hay backend que lo asigne)
    fun generarFolio(): String {
        return "RIETI-2026-" + (1000..9999).random()
    }
}
