package com.simec.alet.domain.model

import com.simec.alet.data.model.RoleDto

data class PayloadData(
    val accessToken: String,
    val companyImage: String,
    val companyName: String,
    val isAdmin: Boolean,
    val isAffiliator: Boolean,
    val isCustomer: Boolean,
    val isEmployee: Boolean,
    val isSuperAdmin: Boolean,
    val isUser: Boolean,
    val phone: String,
    val roleDtos: List<RoleDto>?,
    val userId: String,
    val userName: String
)