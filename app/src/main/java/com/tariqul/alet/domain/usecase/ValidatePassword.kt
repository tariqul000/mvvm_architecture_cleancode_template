package com.tariqul.alet.domain.usecase

import com.tariqul.alet.R
import com.tariqul.alet.UiText
import com.tariqul.alet.ValidationResult


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