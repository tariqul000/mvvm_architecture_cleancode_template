package com.simec.gfs.data.model

import com.google.gson.annotations.SerializedName

data class PayloadDto(
    @SerializedName("count")
    val count: Int,

    @SerializedName("data")
    val data: PayloadDataDto
)