package com.rieti.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashViewModel : ViewModel() {

    // Guarda si el usuario quiere reporte anónimo (true) o con seguimiento (false)
    private val _esAnonimo = MutableLiveData(true)
    val esAnonimo: LiveData<Boolean> = _esAnonimo

    fun seleccionarAnonimo() {
        _esAnonimo.value = true
    }

    fun seleccionarConSeguimiento() {
        _esAnonimo.value = false
    }
}
