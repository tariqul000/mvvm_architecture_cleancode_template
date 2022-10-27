package com.simec.alet.data.remote.source

import com.simec.alet.data.model.PayloadDto
import com.simec.alet.data.remote.request.LoginRequest
import com.simec.alet.responses.ApiResponse
import com.simec.alet.responses.ResponseDTO

interface AuthDataSource {

    suspend fun doSignIn(
        body: LoginRequest
    ): ApiResponse<ResponseDTO<PayloadDto>>
}
