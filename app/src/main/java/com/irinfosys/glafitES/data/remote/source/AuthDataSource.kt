package com.irinfosys.glafitES.data.remote.source

import com.irinfosys.glafitES.data.model.PayloadDto
import com.irinfosys.glafitES.data.remote.request.LoginRequest
import com.irinfosys.glafitES.responses.ApiResponse
import com.irinfosys.glafitES.responses.ResponseDTO

interface AuthDataSource {

    suspend fun doSignIn(
        body: LoginRequest
    ): ApiResponse<ResponseDTO<PayloadDto>>
}
