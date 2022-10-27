package com.simec.alet.lang

import com.simec.alet.SharedPref


class LanguageProvider constructor(
    private val sharedPref: SharedPref
) {

    companion object {
        private const val PREF_LANGUAGE_CODE = "pref_language_code"
        const val LANG_CODE_BN = "bn"
        const val LANG_CODE_EN = "en"
    }

    fun setCurrentLanguage(languageCode: String) {
        sharedPref.write(PREF_LANGUAGE_CODE, languageCode)
    }

    fun getCurrentLanguage() = sharedPref.read(PREF_LANGUAGE_CODE, LANG_CODE_EN)

    fun hasLanguagesSet()= sharedPref.read(PREF_LANGUAGE_CODE, "").isNotEmpty()
}