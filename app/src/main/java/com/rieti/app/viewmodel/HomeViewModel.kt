package com.rieti.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _isAdmin = MutableLiveData(false)
    val isAdmin: LiveData<Boolean> = _isAdmin

    private val _tituloTarjeta = MutableLiveData<String>()
    val tituloTarjeta: LiveData<String> = _tituloTarjeta

    private val _totalReportes = MutableLiveData<String>()
    val totalReportes: LiveData<String> = _totalReportes

    // Función básica: ajusta los datos del dashboard según el rol (usuario o admin)
    fun cargarDatos(esAdmin: Boolean) {
        _isAdmin.value = esAdmin
        if (esAdmin) {
            _tituloTarjeta.value = "Reportes realizados en el año"
            _totalReportes.value = "100"
        } else {
            _tituloTarjeta.value = "Mis Reportes Creados"
            _totalReportes.value = "12"
        }
    }
}
