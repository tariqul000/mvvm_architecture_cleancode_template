package com.tariqul.alet

data class ValidationResult(
    val isSuccessful: Boolean,
    val errorMessage: UiText? = null
)