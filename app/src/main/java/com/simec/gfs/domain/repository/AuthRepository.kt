package com.simec.gfs.domain.repository

import com.simec.gfs.Resource
import com.simec.gfs.data.remote.request.LoginRequest
import com.simec.gfs.domain.model.Payload


interface AuthRepository {
    suspend fun doSignIn(
        body: LoginRequest
    ): Resource<Payload>

}