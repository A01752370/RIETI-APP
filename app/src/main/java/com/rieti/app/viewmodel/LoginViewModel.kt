package com.rieti.app.viewmodel

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    // Función básica de demo: si el correo contiene "admin", entra como administrador.
    // No hay backend todavía, es solo para probar la navegación con los dos roles.
    fun esAdmin(correo: String): Boolean {
        return correo.contains("admin", ignoreCase = true)
    }
}
