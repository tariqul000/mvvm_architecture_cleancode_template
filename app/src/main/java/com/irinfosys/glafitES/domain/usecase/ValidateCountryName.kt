package com.irinfosys.glafitES.domain.usecase

import com.irinfosys.glafitES.style.R
import com.irinfosys.glafitES.UiText
import com.irinfosys.glafitES.ValidationResult


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