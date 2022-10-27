package com.tariqul.alet.data.remote.source

import com.tariqul.alet.data.remote.api.AuthApiService
import com.tariqul.alet.data.remote.request.LoginRequest
import com.tariqul.alet.middleware.SafeApiRequest

class AuthDataSourceImpl(
    private val apiService: AuthApiService
) : SafeApiRequest(), AuthDataSource {

    override suspend fun doSignIn(body: LoginRequest) = apiRequest {
        apiService.doSignIn(body)
    }
}