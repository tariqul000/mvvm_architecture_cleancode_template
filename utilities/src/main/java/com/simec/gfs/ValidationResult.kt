package com.simec.gfs

data class ValidationResult(
    val isSuccessful: Boolean,
    val errorMessage: UiText? = null
)