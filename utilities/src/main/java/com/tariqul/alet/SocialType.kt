package com.tariqul.alet

sealed class SocialType(val type: String) {

    object Facebook : SocialType(FACEBOOK)
    object Google : SocialType(GOOGLE)
    object Twitter : SocialType(TWITTER)
    object LinkedIn : SocialType(LINKEDIN)
    object Unknown : SocialType(UNKNOWN)

    companion object {
        private const val FACEBOOK = "facebook"
        private const val GOOGLE = "google"
        private const val TWITTER = "twitter"
        private const val LINKEDIN = "linkedin"
        private const val UNKNOWN = "unknown"

        private fun getSocialType(type: String): SocialType {
            return when (type) {
                FACEBOOK -> Facebook
                GOOGLE -> Google
                TWITTER -> Twitter
                LINKEDIN -> LinkedIn
                else -> Unknown
            }
        }

        fun isNotValidSocialType(type: String): Boolean {
            return getSocialType(type) is Unknown
        }
    }

}