package com.tariqul.alet.responses.error

import com.tariqul.alet.style.R
import com.tariqul.alet.UiText
import com.tariqul.alet.responses.ApiResponse.Companion.UNKNOWN_ERROR_CODE

data class ApiError(
    val error: Error?
)

fun ApiError?.toUiText(code: Int = UNKNOWN_ERROR_CODE): UiText {
    this ?: return UiText.StringResource(
        R.string.message_unknown_error
    )
    val fieldsErrors = error?.fields?.errors?.map { it.message }
    val systemErrors = error?.systems?.errors?.map { it.message }
    return if (!fieldsErrors.isNullOrEmpty()) {
        UiText.DynamicString(fieldsErrors.joinToString(","))
    } else {
        if (!systemErrors.isNullOrEmpty()) {
            UiText.DynamicString(systemErrors.joinToString(","))
        } else {
            UiText.StringResource(R.string.message_unknown_error)
        }
    }
}