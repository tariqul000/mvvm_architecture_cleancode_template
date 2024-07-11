package com.simec.gfs.domain.usecase

import com.simec.gfs.style.R
import com.simec.gfs.UiText
import com.simec.gfs.ValidationResult


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