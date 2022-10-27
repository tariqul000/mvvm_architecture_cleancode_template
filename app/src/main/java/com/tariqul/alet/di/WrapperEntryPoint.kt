package com.tariqul.alet.di

import com.tariqul.alet.lang.LanguageProvider
import dagger.hilt.InstallIn
import dagger.hilt.android.EarlyEntryPoint
import dagger.hilt.components.SingletonComponent

@EarlyEntryPoint
@InstallIn(SingletonComponent::class)
interface WrapperEntryPoint {
    fun languageProvider(): LanguageProvider
}
