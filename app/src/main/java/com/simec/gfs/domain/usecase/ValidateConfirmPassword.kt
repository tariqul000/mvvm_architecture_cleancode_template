package com.simec.gfs.domain.usecase
import com.simec.gfs.style.R
import com.simec.gfs.UiText
import com.simec.gfs.ValidationResult

class ValidateConfirmPassword {
    operator fun invoke(password: String, confirmPassword: String): ValidationResult {
        if (password != confirmPassword) {
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