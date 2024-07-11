package com.simec.gfs.di

import android.content.Context
import com.google.gson.Gson
import com.simec.gfs.SharedPref
import com.simec.gfs.lang.LanguageProvider
import com.simec.gfs.theme.ThemeProvider
import com.simec.gfs.util.UserFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideSharedPref(
        @ApplicationContext context: Context
    ): SharedPref = SharedPref(
        context
    )

    @Provides
    @Singleton
    fun provideUserFactory(
        sharedPref: SharedPref,
        gson: Gson
    ): UserFactory = UserFactory(sharedPref, gson)


    @Provides
    @Singleton
    fun provideLanguageProvider(
        sharedPref: SharedPref
    ): LanguageProvider = LanguageProvider(sharedPref)

    @Provides
    @Singleton
    fun provideThemeProvider(
        sharedPref: SharedPref
    ): ThemeProvider = ThemeProvider(sharedPref)



}