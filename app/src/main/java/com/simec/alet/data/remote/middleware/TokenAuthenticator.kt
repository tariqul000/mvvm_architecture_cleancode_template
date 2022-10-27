package com.simec.alet.data.remote.middleware

import com.simec.alet.domain.repository.AuthRepository
import com.simec.alet.util.UserFactory
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route


class TokenAuthenticator(
    private val userFactory: UserFactory,
    private val authRepository: AuthRepository
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        val hasSocialLogin = userFactory.hasSocialLogin()

        val accessToken = if (hasSocialLogin) {
            userFactory.getAccessToken()
        } else {
            refreshToken()
        }
        if (!hasSocialLogin)
            userFactory.saveAccessToken(accessToken)

        val token = if (accessToken.isNotEmpty()) {
            "Bearer $accessToken"
        } else {
            ""
        }
        return response.request.newBuilder()
            .header("Authorization", token)
            .build()
    }

    private fun refreshToken(): String {
        val loginRequest = userFactory.getLoginRequest()
        return if (loginRequest != null) {
//            val signInResponse = authRepository.refreshToken(
//                loginRequest
//            ).execute().body()
           // signInResponse?.dto?.accessToken ?: ""
            ""
        } else {
            ""
        }
    }
}