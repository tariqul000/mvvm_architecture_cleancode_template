package com.simec.gfs.data.remote.source

import com.simec.gfs.data.model.PayloadDto
import com.simec.gfs.data.remote.request.LoginRequest
import com.simec.gfs.responses.ApiResponse
import com.simec.gfs.responses.ResponseDTO

interface AuthDataSource {

    suspend fun doSignIn(
        body: LoginRequest
    ): ApiResponse<ResponseDTO<PayloadDto>>
}
