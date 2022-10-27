package com.tariqul.alet

interface TokenWrapper {
    fun getAccessToken(): String
    fun saveAccessToken(token: String)

}