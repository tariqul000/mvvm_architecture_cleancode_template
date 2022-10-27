package com.tariqul.alet.data.mapper

import com.tariqul.alet.data.model.PayloadDataDto
import com.tariqul.alet.data.model.PayloadDto
import com.tariqul.alet.domain.model.Payload
import com.tariqul.alet.domain.model.PayloadData

fun PayloadDto.toPayload() = Payload(
    count = count,
    data = data.toPayloadData()
)

fun PayloadDataDto.toPayloadData() = PayloadData(
     accessToken = accessToken,
     companyImage = companyImage,
     companyName = companyName,
     isAdmin = isAdmin,
     isAffiliator = isAffiliator,
     isCustomer = isCustomer,
     isEmployee = isEmployee,
     isSuperAdmin = isSuperAdmin,
     isUser = isUser,
     phone = phone,
     roleDtos = roleDtos ?: emptyList(),
     userId = userId,
     userName = userName
)