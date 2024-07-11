package com.simec.gfs.data.mapper

import com.simec.gfs.data.model.PayloadDataDto
import com.simec.gfs.data.model.PayloadDto
import com.simec.gfs.domain.model.Payload
import com.simec.gfs.domain.model.PayloadData

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