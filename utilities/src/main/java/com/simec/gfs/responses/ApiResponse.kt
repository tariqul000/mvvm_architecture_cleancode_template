package com.simec.gfs.responses

import android.util.Log
import com.simec.gfs.body.getError
import com.simec.gfs.utilities.BuildConfig
import com.simec.gfs.style.R
import com.simec.gfs.UiText
import com.simec.gfs.responses.error.ApiError
import com.simec.gfs.responses.error.toUiText
import retrofit2.Response


sealed class ApiResponse<T> {

    companion object {
        const val UNKNOWN_ERROR_CODE = 444
        const val EMPTY_ERROR_CODE = 2004

        fun <T> create(error: UiText, code: Int = 444): ApiEmptyResponse<T> {
            return ApiEmptyResponse(error, code)
        }

        fun <T> create(response: Response<T>): ApiResponse<T> {
            return if (response.isSuccessful) {
                val body = response.body()
                Log.e("ApiResponse Success", "create: $body")
                if (BuildConfig.DEBUG) {
                    Log.e("ApiResponse", "create: $body ${response.raw()}")
                }
                if (body == null || response.code() == 204) {
                    ApiEmptyResponse(
                        UiText.StringResource(R.string.message_unknown_error),
                        response.code()
                    )
                } else {
                    ApiSuccessResponse(
                        body = body
                    )
                }
            } else {
                val code = response.code()
                val error = response.errorBody().getError<ApiError>()
                Log.e("ApiResponse", "create: error $error")
                if (error != null) {
                    ApiErrorResponse(error.toUiText(code), code)
                } else {
                    ApiEmptyResponse(
                        UiText.StringResource(R.string.message_unknown_error),
                        UNKNOWN_ERROR_CODE
                    )
                }
            }
        }
    }

}


class ApiEmptyResponse<T>(val text: UiText, val code: Int) : ApiResponse<T>()

data class ApiSuccessResponse<T>(val body: T) : ApiResponse<T>()

data class ApiErrorResponse<T>(val text: UiText, val code: Int) : ApiResponse<T>()