package com.simec.alet

interface TokenWrapper {
    fun getAccessToken(): String
    fun saveAccessToken(token: String)

}