package com.tariqul.alet.data.remote.source

import com.tariqul.alet.data.model.PayloadDto
import com.tariqul.alet.data.remote.request.LoginRequest
import com.tariqul.alet.responses.ApiResponse
import com.tariqul.alet.responses.ResponseDTO

interface AuthDataSource {

    suspend fun doSignIn(
        body: LoginRequest
    ): ApiResponse<ResponseDTO<PayloadDto>>
}
