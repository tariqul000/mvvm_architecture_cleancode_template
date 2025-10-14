package com.irinfosys.glafitES.domain.usecase

import android.util.Patterns
import com.irinfosys.glafitES.style.R
import com.irinfosys.glafitES.UiText
import com.irinfosys.glafitES.ValidationResult


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