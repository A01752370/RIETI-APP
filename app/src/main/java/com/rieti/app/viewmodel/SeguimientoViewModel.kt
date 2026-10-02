package com.rieti.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SeguimientoViewModel : ViewModel() {

    private val _folio = MutableLiveData("RIETI-0000")
    val folio: LiveData<String> = _folio

    private val _estatus = MutableLiveData("Registrado")
    val estatus: LiveData<String> = _estatus

    fun cargarCaso(folio: String, estatus: String) {
        _folio.value = folio
        _estatus.value = estatus
    }

    // Simula guardar el comentario del administrador (todavía sin backend)
    fun actualizarReporte(comentario: String): String {
        return "Comentario guardado (demo, sin backend)"
    }
}
