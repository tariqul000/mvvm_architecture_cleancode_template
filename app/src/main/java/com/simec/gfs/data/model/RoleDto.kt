package com.simec.gfs.data.model

import com.google.gson.annotations.SerializedName

data class RoleDto(
    @SerializedName("role")
    val role: String
)