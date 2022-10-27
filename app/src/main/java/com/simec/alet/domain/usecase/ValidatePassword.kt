package com.simec.alet.domain.usecase

import com.simec.alet.R
import com.simec.alet.UiText
import com.simec.alet.ValidationResult


class ValidatePassword {
    operator fun invoke(password: String): ValidationResult {
        if (password.isEmpty() || password.length < 3) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = UiText.StringResource(
                    R.string.password_length_must_6
                )
            )
        }
        return ValidationResult(
            isSuccessful = true
        )
    }
}