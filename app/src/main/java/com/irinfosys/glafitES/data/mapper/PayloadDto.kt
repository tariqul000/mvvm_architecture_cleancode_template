package com.irinfosys.glafitES.data.mapper

import com.irinfosys.glafitES.data.model.PayloadDataDto
import com.irinfosys.glafitES.data.model.PayloadDto
import com.irinfosys.glafitES.domain.model.Payload
import com.irinfosys.glafitES.domain.model.PayloadData

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