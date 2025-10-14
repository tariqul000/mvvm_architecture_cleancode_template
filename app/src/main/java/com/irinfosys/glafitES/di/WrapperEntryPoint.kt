package com.irinfosys.glafitES.di

import com.irinfosys.glafitES.lang.LanguageProvider
import dagger.hilt.InstallIn
import dagger.hilt.android.EarlyEntryPoint
import dagger.hilt.components.SingletonComponent

@EarlyEntryPoint
@InstallIn(SingletonComponent::class)
interface WrapperEntryPoint {
    fun languageProvider(): LanguageProvider
}
