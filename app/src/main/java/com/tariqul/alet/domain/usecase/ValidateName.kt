package com.tariqul.alet.domain.usecase

import com.tariqul.alet.R
import com.tariqul.alet.UiText
import com.tariqul.alet.ValidationResult


class ValidateName {
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