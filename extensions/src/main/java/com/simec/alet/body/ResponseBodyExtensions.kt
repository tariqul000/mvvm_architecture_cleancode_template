package com.simec.alet.body

import com.google.gson.Gson
import okhttp3.ResponseBody
import org.json.JSONObject

inline fun <reified T> ResponseBody?.getError(): T? {
    if (this == null) return null
    val jsonObject = JSONObject(charStream().readText())
    return try {
        Gson().fromJson(jsonObject.toString(), T::class.java)
    } catch (e: Exception) {
        null
    }
}