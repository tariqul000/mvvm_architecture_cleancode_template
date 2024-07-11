package com.simec.gfs.presentation

import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import com.simec.gfs.SharedPref
import com.simec.gfs.di.WrapperEntryPoint
import com.simec.gfs.lang.LanguageProvider
import com.simec.gfs.theme.ThemeProvider
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