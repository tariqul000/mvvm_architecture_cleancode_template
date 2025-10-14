package com.irinfosys.glafitES.data.remote.source

import com.irinfosys.glafitES.data.remote.api.AuthApiService
import com.irinfosys.glafitES.data.remote.request.LoginRequest
import com.irinfosys.glafitES.middleware.SafeApiRequest

class AuthDataSourceImpl(
    private val apiService: AuthApiService
) : SafeApiRequest(), AuthDataSource {

    override suspend fun doSignIn(body: LoginRequest) = apiRequest {
        apiService.doSignIn(body)
    }
}