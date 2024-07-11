package com.simec.gfs.domain.usecase

import android.util.Patterns
import com.simec.gfs.style.R
import com.simec.gfs.UiText
import com.simec.gfs.ValidationResult


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