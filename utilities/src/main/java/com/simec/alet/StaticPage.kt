package com.simec.alet

import java.io.Serializable

sealed class StaticPage(val page: String): Serializable {

    object AboutUs : StaticPage(PAGE_ABOUT_US)
    object TermsCondition : StaticPage(PAGE_TERMS_CONDITION)
    object PrivacyPolicy : StaticPage(PAGE_PRIVACY_POLICY)
    object Unknown : StaticPage(PAGE_UNKNOWN)

    companion object {
        private const val PAGE_ABOUT_US = "aboutus"
        private const val PAGE_TERMS_CONDITION = "trams-condition"
        private const val PAGE_PRIVACY_POLICY = "privacy-policy"
        private const val PAGE_UNKNOWN = "unknown"

        fun getPage(page: String): StaticPage {
            return when (page) {
                PAGE_ABOUT_US -> AboutUs
                PAGE_TERMS_CONDITION -> TermsCondition
                PAGE_PRIVACY_POLICY -> PrivacyPolicy
                else -> Unknown
            }
        }
    }
}
