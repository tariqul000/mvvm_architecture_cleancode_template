package com.irinfosys.glafitES.responses.error

import com.irinfosys.glafitES.style.R
import com.irinfosys.glafitES.UiText
import com.irinfosys.glafitES.responses.ApiResponse.Companion.UNKNOWN_ERROR_CODE

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