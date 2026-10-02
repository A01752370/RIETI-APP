package com.rieti.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConfirmacionViewModel : ViewModel() {

    private val _folio = MutableLiveData("RIETI-2026-0000")
    val folio: LiveData<String> = _folio

    fun setFolio(valor: String) {
        _folio.value = valor
    }
}
