package com.irinfosys.glafitES.domain.usecase
import com.irinfosys.glafitES.style.R
import com.irinfosys.glafitES.UiText
import com.irinfosys.glafitES.ValidationResult

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