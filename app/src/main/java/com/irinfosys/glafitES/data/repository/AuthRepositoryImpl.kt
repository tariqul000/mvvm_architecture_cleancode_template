package com.irinfosys.glafitES.data.repository

import com.irinfosys.glafitES.style.R
import com.irinfosys.glafitES.Resource
import com.irinfosys.glafitES.UiText
import com.irinfosys.glafitES.data.mapper.toPayload
import com.irinfosys.glafitES.data.remote.request.LoginRequest
import com.irinfosys.glafitES.data.remote.source.AuthDataSource
import com.irinfosys.glafitES.domain.repository.AuthRepository
import com.irinfosys.glafitES.responses.ApiEmptyResponse
import com.irinfosys.glafitES.responses.ApiErrorResponse
import com.irinfosys.glafitES.responses.ApiResponse.Companion.UNKNOWN_ERROR_CODE
import com.irinfosys.glafitES.responses.ApiSuccessResponse


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