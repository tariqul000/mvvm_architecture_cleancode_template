package com.tariqul.alet.data.remote.api

import com.tariqul.alet.data.model.PayloadDto
import com.tariqul.alet.data.remote.request.LoginRequest
import com.tariqul.alet.responses.ResponseDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST("/api/auth/login")
    suspend fun doSignIn(
        @Body body: LoginRequest
    ): Response<ResponseDTO<PayloadDto>>


}