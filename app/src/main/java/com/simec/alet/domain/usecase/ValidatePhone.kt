package com.simec.alet.domain.usecase

import com.simec.alet.R
import com.simec.alet.UiText
import com.simec.alet.ValidationResult

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