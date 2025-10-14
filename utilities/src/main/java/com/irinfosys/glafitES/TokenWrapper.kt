package com.irinfosys.glafitES

interface TokenWrapper {
    fun getAccessToken(): String
    fun saveAccessToken(token: String)

}