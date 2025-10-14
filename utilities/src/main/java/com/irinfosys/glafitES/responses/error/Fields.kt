package com.irinfosys.glafitES.responses.error

data class Fields(
    val count: Int?,
    val errors: List<FieldError>?
)