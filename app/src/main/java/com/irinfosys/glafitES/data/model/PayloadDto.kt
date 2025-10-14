package com.irinfosys.glafitES.data.model

import com.google.gson.annotations.SerializedName

data class PayloadDto(
    @SerializedName("count")
    val count: Int,

    @SerializedName("data")
    val data: PayloadDataDto
)