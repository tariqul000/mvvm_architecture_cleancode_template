package com.simec.alet.data.remote.api

import com.simec.alet.data.model.PayloadDto
import com.simec.alet.data.remote.request.LoginRequest
import com.simec.alet.responses.ResponseDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST("/api/auth/login")
    suspend fun doSignIn(
        @Body body: LoginRequest
    ): Response<ResponseDTO<PayloadDto>>


}