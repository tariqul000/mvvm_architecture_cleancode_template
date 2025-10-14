package com.irinfosys.glafitES.data.remote.api

import com.irinfosys.glafitES.data.model.PayloadDto
import com.irinfosys.glafitES.data.remote.request.LoginRequest
import com.irinfosys.glafitES.responses.ResponseDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST("/api/auth/login")
    suspend fun doSignIn(
        @Body body: LoginRequest
    ): Response<ResponseDTO<PayloadDto>>


}