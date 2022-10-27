package com.tariqul.alet.util

import com.google.gson.Gson
import com.tariqul.alet.SharedPref
import com.tariqul.alet.data.remote.request.LoginRequest


class UserFactory(
    private val sharedPref: SharedPref, private val gson: Gson
) {
    companion object {
        private const val PREF_ACCESS_TOKEN = "pref_access_token"
        private const val PREF_LOGIN_REQUEST = "pref_login_request"
        private const val PREF_LOGIN_TYPE = "pref_login_type"

        const val TYPE_SOCIAL = "social"
        const val TYPE_CREDENTIAL = "credential"
    }

    fun saveLoginType(type: String) {
        sharedPref.write(PREF_LOGIN_TYPE, type)
    }

    fun hasSocialLogin(): Boolean {
        return sharedPref.read(PREF_LOGIN_TYPE, TYPE_CREDENTIAL) == TYPE_SOCIAL
    }

    fun getAccessToken(): String = sharedPref.read(PREF_ACCESS_TOKEN, "")

    fun saveAccessToken(token: String) {
        sharedPref.write(PREF_ACCESS_TOKEN, token)
    }

    fun getLoginRequest(): LoginRequest? {
        val requestText = sharedPref.read(PREF_LOGIN_REQUEST, "")
        return if (requestText.isNotEmpty()) {
            gson.fromJson(requestText, LoginRequest::class.java)
        } else {
            null
        }
    }

    fun saveLoginRequest(loginRequest: LoginRequest) {
        sharedPref.write(PREF_LOGIN_REQUEST, gson.toJson(loginRequest))
    }


    fun clear() {
        sharedPref.clear()
    }

}