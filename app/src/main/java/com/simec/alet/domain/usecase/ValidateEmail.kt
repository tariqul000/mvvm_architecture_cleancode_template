package com.simec.alet.domain.usecase

import android.util.Patterns
import com.simec.alet.R
import com.simec.alet.UiText
import com.simec.alet.ValidationResult


class ValidateEmail {
    operator fun invoke(email: String): ValidationResult {
        if (email.isEmpty()) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = UiText.StringResource(
                    R.string.email_cant_blank
                )
            )
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = UiText.StringResource(
                    R.string.invalid_email_address
                )
            )
        }

        return ValidationResult(
            isSuccessful = true
        )
    }
}