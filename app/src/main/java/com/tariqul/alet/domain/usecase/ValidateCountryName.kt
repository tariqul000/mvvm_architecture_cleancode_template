package com.tariqul.alet.domain.usecase

import com.tariqul.alet.R
import com.tariqul.alet.UiText
import com.tariqul.alet.ValidationResult


class ValidateCountryName {
    operator fun invoke(countryName: String): ValidationResult {
        if (countryName.isEmpty()) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = UiText.StringResource(
                    R.string.country_name_must_be_non_empty
                )
            )
        }
        return ValidationResult(
            isSuccessful = true
        )
    }
}