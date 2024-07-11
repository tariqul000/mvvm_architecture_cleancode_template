package com.simec.gfs.domain.usecase

import com.simec.gfs.style.R
import com.simec.gfs.UiText
import com.simec.gfs.ValidationResult

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