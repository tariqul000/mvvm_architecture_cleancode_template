package com.simec.alet.responses.error

data class Fields(
    val count: Int?,
    val errors: List<FieldError>?
)