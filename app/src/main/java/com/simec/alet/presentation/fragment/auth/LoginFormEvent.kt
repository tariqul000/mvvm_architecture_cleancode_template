package com.simec.alet.presentation.fragment.auth


sealed class LoginFormEvent {
    data class PhoneChanged(val phone: String) : LoginFormEvent()
    data class PasswordChanged(val password: String) : LoginFormEvent()
    object Submit : LoginFormEvent()
}