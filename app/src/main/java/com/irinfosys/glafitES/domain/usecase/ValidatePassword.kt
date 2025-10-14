package com.irinfosys.glafitES.domain.usecase

import com.irinfosys.glafitES.style.R
import com.irinfosys.glafitES.UiText
import com.irinfosys.glafitES.ValidationResult


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