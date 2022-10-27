package com.tariqul.alet.data.remote.request

data class LoginRequest(
    val phone: String,
    val password: String,
    val isChecked: Int = 0
)