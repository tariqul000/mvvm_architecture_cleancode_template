package com.simec.alet.presentation

import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import com.simec.alet.SharedPref
import com.simec.alet.di.WrapperEntryPoint
import com.simec.alet.lang.LanguageProvider
import com.simec.alet.theme.ThemeProvider
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApp : MultiDexApplication() {

    @Inject
    lateinit var sharedPref: SharedPref

    @Inject
    lateinit var themeProvider: ThemeProvider

    lateinit var languageProvider: LanguageProvider

    override fun onCreate() {
        super.onCreate()
        languageProvider = EntryPointAccessors.fromApplication(this, WrapperEntryPoint::class.java)
            .languageProvider()

        val theme = themeProvider.getCurrentTheme()
        AppCompatDelegate.setDefaultNightMode(theme)

    }
}