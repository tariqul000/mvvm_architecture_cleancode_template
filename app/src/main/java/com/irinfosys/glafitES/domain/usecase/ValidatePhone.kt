package com.irinfosys.glafitES.domain.usecase

import com.irinfosys.glafitES.style.R
import com.irinfosys.glafitES.UiText
import com.irinfosys.glafitES.ValidationResult

class ValidatePhone {
    operator fun invoke(name: String): ValidationResult {
        if (name.isEmpty()) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = UiText.StringResource(
                    R.string.name_must_be_non_empty
                )
            )
        }
        return ValidationResult(
            isSuccessful = true
        )
    }
}