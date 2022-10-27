package com.simec.alet.data.remote.source

import com.simec.alet.data.remote.api.AuthApiService
import com.simec.alet.data.remote.request.LoginRequest
import com.simec.alet.middleware.SafeApiRequest

class AuthDataSourceImpl(
    private val apiService: AuthApiService
) : SafeApiRequest(), AuthDataSource {

    override suspend fun doSignIn(body: LoginRequest) = apiRequest {
        apiService.doSignIn(body)
    }
}