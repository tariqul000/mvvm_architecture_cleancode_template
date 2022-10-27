package com.simec.alet.domain.usecase

import com.simec.alet.R
import com.simec.alet.UiText
import com.simec.alet.ValidationResult


class ValidateOtp {

    operator fun invoke(otp: String, serverOtp: String): ValidationResult {
        if (otp.isEmpty()) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = UiText.StringResource(
                    R.string.otp_cant_blank
                )
            )
        }

        if (otp.length < 6) {
            return ValidationResult(
                isSuccessful = false,
                errorMessage = UiText.StringResource(
                    R.string.otp_must_be_6_characters_length
                )
            )
        }
        if(otp != serverOtp){
            return ValidationResult(
                isSuccessful = false,
                errorMessage = UiText.StringResource(
                    R.string.otp_does_not_match
                )
            )
        }

        return ValidationResult(
            isSuccessful = true
        )
    }
}