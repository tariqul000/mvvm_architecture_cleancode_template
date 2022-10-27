package com.simec.alet.responses.error

data class Systems(
    val count: Int?,
    val errors: List<SystemError>?
)