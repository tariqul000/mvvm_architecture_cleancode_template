package com.irinfosys.glafitES.di

import android.content.Context
import com.irinfosys.glafitES.BuildConfig
import com.irinfosys.glafitES.data.remote.api.AuthApiService
import com.irinfosys.glafitES.data.remote.middleware.ConnectivityInterceptorImpl
import com.irinfosys.glafitES.data.remote.middleware.TokenAuthenticator
import com.irinfosys.glafitES.data.remote.source.AuthDataSource
import com.irinfosys.glafitES.data.remote.source.AuthDataSourceImpl
import com.irinfosys.glafitES.data.repository.AuthRepositoryImpl
import com.irinfosys.glafitES.di.anotation.Auth
import com.irinfosys.glafitES.domain.repository.AuthRepository
import com.irinfosys.glafitES.middleware.ConnectivityInterceptor
import com.irinfosys.glafitES.util.UserFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideConnectivityInterceptor(
        @ApplicationContext context: Context
    ): ConnectivityInterceptor = ConnectivityInterceptorImpl(context)

    @Auth
    @Provides
    @Singleton
    fun provideOkHttpClient(
        connectivityInterceptor: ConnectivityInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(connectivityInterceptor)
        .build()

    @Auth
    @Provides
    @Singleton
    fun provideAuthApiService(
        @Auth okHttpClient: OkHttpClient
    ): AuthApiService = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(AuthApiService::class.java)

    @Provides
    @Singleton
    fun provideAuthDataSource(
        @Auth authApiService: AuthApiService
    ): AuthDataSource = AuthDataSourceImpl(authApiService)

    @Provides
    @Singleton
    fun provideAuthRepository(
        authDataSource: AuthDataSource
    ): AuthRepository = AuthRepositoryImpl(authDataSource)


    @Provides
    @Singleton
    fun provideTokenAuthenticator(
        userFactory: UserFactory,
        authRepository: AuthRepository
    ): TokenAuthenticator {
        return TokenAuthenticator(userFactory, authRepository)
    }

}