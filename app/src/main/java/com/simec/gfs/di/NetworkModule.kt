package com.simec.gfs.di

import android.content.Context
import com.simec.gfs.BuildConfig
import com.simec.gfs.data.remote.api.AuthApiService
import com.simec.gfs.data.remote.middleware.ConnectivityInterceptorImpl
import com.simec.gfs.data.remote.middleware.TokenAuthenticator
import com.simec.gfs.data.remote.source.AuthDataSource
import com.simec.gfs.data.remote.source.AuthDataSourceImpl
import com.simec.gfs.data.repository.AuthRepositoryImpl
import com.simec.gfs.di.anotation.Auth
import com.simec.gfs.domain.repository.AuthRepository
import com.simec.gfs.middleware.ConnectivityInterceptor
import com.simec.gfs.util.UserFactory
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