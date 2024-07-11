package com.simec.gfs.domain.usecase

import com.simec.gfs.style.R
import com.simec.gfs.UiText
import com.simec.gfs.ValidationResult


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