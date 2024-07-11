package com.simec.gfs.responses.error

data class Fields(
    val count: Int?,
    val errors: List<FieldError>?
)