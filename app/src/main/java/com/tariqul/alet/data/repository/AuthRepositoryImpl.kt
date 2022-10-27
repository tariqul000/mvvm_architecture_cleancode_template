package com.tariqul.alet.data.repository

import com.tariqul.alet.R
import com.tariqul.alet.Resource
import com.tariqul.alet.UiText
import com.tariqul.alet.data.mapper.toPayload
import com.tariqul.alet.data.remote.request.LoginRequest
import com.tariqul.alet.data.remote.source.AuthDataSource
import com.tariqul.alet.domain.repository.AuthRepository
import com.tariqul.alet.responses.ApiEmptyResponse
import com.tariqul.alet.responses.ApiErrorResponse
import com.tariqul.alet.responses.ApiResponse.Companion.UNKNOWN_ERROR_CODE
import com.tariqul.alet.responses.ApiSuccessResponse


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