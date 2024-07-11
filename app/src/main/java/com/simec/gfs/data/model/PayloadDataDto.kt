package com.simec.gfs.data.model

import com.google.gson.annotations.SerializedName

data class PayloadDataDto(
    @SerializedName("accessToken")
    val accessToken: String,
    @SerializedName("companyImage")
    val companyImage: String,
    @SerializedName("companyName")
    val companyName: String,
    @SerializedName("isAdmin")
    val isAdmin: Boolean,
    @SerializedName("isAffiliator")
    val isAffiliator: Boolean,
    @SerializedName("isCustomer")
    val isCustomer: Boolean,
    @SerializedName("isEmployee")
    val isEmployee: Boolean,
    @SerializedName("isSuperAdmin")
    val isSuperAdmin: Boolean,
    @SerializedName("isUser")
    val isUser: Boolean,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("roleDtos")
    val roleDtos: List<RoleDto>?,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("userName")
    val userName: String
)