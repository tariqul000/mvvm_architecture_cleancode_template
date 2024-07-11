package com.simec.gfs.di

import com.simec.gfs.lang.LanguageProvider
import dagger.hilt.InstallIn
import dagger.hilt.android.EarlyEntryPoint
import dagger.hilt.components.SingletonComponent

@EarlyEntryPoint
@InstallIn(SingletonComponent::class)
interface WrapperEntryPoint {
    fun languageProvider(): LanguageProvider
}
