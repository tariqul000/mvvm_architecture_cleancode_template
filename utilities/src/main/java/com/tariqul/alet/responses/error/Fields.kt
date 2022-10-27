package com.tariqul.alet.responses.error

data class Fields(
    val count: Int?,
    val errors: List<FieldError>?
)