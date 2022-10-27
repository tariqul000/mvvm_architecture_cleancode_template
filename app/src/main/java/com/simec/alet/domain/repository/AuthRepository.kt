package com.simec.alet.domain.repository

import com.simec.alet.Resource
import com.simec.alet.data.remote.request.LoginRequest
import com.simec.alet.domain.model.Payload
import retrofit2.Call


interface AuthRepository {
    suspend fun doSignIn(
        body: LoginRequest
    ): Resource<Payload>

}