package com.irinfosys.glafitES

data class ValidationResult(
    val isSuccessful: Boolean,
    val errorMessage: UiText? = null
)