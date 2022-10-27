package com.simec.alet.domain.usecase

import com.simec.alet.R
import com.simec.alet.UiText
import com.simec.alet.ValidationResult


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