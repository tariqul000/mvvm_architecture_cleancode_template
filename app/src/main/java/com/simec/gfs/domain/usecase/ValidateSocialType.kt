package com.simec.gfs.domain.usecase

import com.simec.gfs.style.R
import com.simec.gfs.SocialType
import com.simec.gfs.UiText
import com.simec.gfs.ValidationResult


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