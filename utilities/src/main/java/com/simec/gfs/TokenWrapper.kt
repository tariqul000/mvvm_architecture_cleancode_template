package com.simec.gfs

interface TokenWrapper {
    fun getAccessToken(): String
    fun saveAccessToken(token: String)

}