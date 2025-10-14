package com.irinfosys.glafitES.domain.repository

import com.irinfosys.glafitES.Resource
import com.irinfosys.glafitES.data.remote.request.LoginRequest
import com.irinfosys.glafitES.domain.model.Payload


interface AuthRepository {
    suspend fun doSignIn(
        body: LoginRequest
    ): Resource<Payload>

}