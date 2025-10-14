package com.irinfosys.glafitES.domain.usecase

import com.irinfosys.glafitES.style.R
import com.irinfosys.glafitES.SocialType
import com.irinfosys.glafitES.UiText
import com.irinfosys.glafitES.ValidationResult


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