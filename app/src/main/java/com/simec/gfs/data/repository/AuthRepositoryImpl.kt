package com.simec.gfs.data.repository

import com.simec.gfs.style.R
import com.simec.gfs.Resource
import com.simec.gfs.UiText
import com.simec.gfs.data.mapper.toPayload
import com.simec.gfs.data.remote.request.LoginRequest
import com.simec.gfs.data.remote.source.AuthDataSource
import com.simec.gfs.domain.repository.AuthRepository
import com.simec.gfs.responses.ApiEmptyResponse
import com.simec.gfs.responses.ApiErrorResponse
import com.simec.gfs.responses.ApiResponse.Companion.UNKNOWN_ERROR_CODE
import com.simec.gfs.responses.ApiSuccessResponse


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