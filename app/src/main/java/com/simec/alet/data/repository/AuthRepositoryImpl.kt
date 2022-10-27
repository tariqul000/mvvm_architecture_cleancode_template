package com.simec.alet.data.repository

import android.util.Log
import com.simec.alet.R
import com.simec.alet.Resource
import com.simec.alet.UiText
import com.simec.alet.data.mapper.toPayload
import com.simec.alet.data.mapper.toPayloadData
import com.simec.alet.data.remote.request.LoginRequest
import com.simec.alet.data.remote.source.AuthDataSource
import com.simec.alet.domain.repository.AuthRepository
import com.simec.alet.responses.ApiEmptyResponse
import com.simec.alet.responses.ApiErrorResponse
import com.simec.alet.responses.ApiResponse.Companion.UNKNOWN_ERROR_CODE
import com.simec.alet.responses.ApiSuccessResponse


class AuthRepositoryImpl(
    private val dataSource: AuthDataSource
) : AuthRepository {

    override suspend fun doSignIn(
        body: LoginRequest
    ) = when (val response = dataSource.doSignIn(body)) {
        is ApiEmptyResponse -> Resource.Failure(response.text, response.code)
        is ApiErrorResponse -> Resource.Failure(response.text, response.code)
        is ApiSuccessResponse -> {
            val dto = response.body.dto
            if (dto != null) {
                Resource.Success(dto.toPayload())
            } else {

                Resource.Failure(
                    UiText.StringResource(
                        R.string.message_unknown_error
                    ),
                    UNKNOWN_ERROR_CODE
                )
            }
        }
    }

}