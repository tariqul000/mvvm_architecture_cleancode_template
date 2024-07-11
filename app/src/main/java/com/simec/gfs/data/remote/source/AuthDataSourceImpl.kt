package com.simec.gfs.data.remote.source

import com.simec.gfs.data.remote.api.AuthApiService
import com.simec.gfs.data.remote.request.LoginRequest
import com.simec.gfs.middleware.SafeApiRequest

class AuthDataSourceImpl(
    private val apiService: AuthApiService
) : SafeApiRequest(), AuthDataSource {

    override suspend fun doSignIn(body: LoginRequest) = apiRequest {
        apiService.doSignIn(body)
    }
}