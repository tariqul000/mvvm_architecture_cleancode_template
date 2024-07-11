package com.simec.gfs.data.remote.api

import com.simec.gfs.data.model.PayloadDto
import com.simec.gfs.data.remote.request.LoginRequest
import com.simec.gfs.responses.ResponseDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST("/api/auth/login")
    suspend fun doSignIn(
        @Body body: LoginRequest
    ): Response<ResponseDTO<PayloadDto>>


}