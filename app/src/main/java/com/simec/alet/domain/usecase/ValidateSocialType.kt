package com.simec.alet.domain.usecase

import com.simec.alet.R
import com.simec.alet.SocialType
import com.simec.alet.UiText
import com.simec.alet.ValidationResult


class ValidateSocialType {
    operator fun invoke(type: String): ValidationResult {
        if (type.isEmpty()) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = UiText.StringResource(
                    R.string.social_type_must_not_be_empty
                )
            )
        }

        if (SocialType.isNotValidSocialType(type)) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = UiText.StringResource(
                    R.string.social_type_not_valid
                )
            )
        }

        return ValidationResult(
            isSuccessful = true
        )
    }
}