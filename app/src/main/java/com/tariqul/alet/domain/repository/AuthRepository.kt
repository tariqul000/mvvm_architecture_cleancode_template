package com.tariqul.alet.domain.repository

import com.tariqul.alet.Resource
import com.tariqul.alet.data.remote.request.LoginRequest
import com.tariqul.alet.domain.model.Payload


interface AuthRepository {
    suspend fun doSignIn(
        body: LoginRequest
    ): Resource<Payload>

}