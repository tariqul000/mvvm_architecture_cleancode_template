package com.simec.alet

data class ValidationResult(
    val isSuccessful: Boolean,
    val errorMessage: UiText? = null
)