package com.simec.gfs.responses.error

data class Systems(
    val count: Int?,
    val errors: List<SystemError>?
)