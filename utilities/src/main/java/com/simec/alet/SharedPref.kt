package com.simec.alet

import android.app.Activity
import android.content.Context


class SharedPref(
    context: Context,
    storageName: String = context.packageName
) {

    private val mSharedPref = context.getSharedPreferences(
        storageName, Activity.MODE_PRIVATE
    )

    fun read(key: String, defValue: String) = mSharedPref.getString(key, defValue)!!

    fun write(key: String, value: String){
        mSharedPref.edit().apply {
            putString(key, value)
            apply()
        }
    }

    fun read(key: String, defValue: Boolean) =
        mSharedPref.getBoolean(key, defValue)

    fun write(key: String, value: Boolean){
        mSharedPref.edit().apply {
            putBoolean(key, value)
            apply()
        }
    }

    fun read(key: String, defValue: Int) =
        mSharedPref.getInt(key, defValue)

    fun write(key: String, value: Int){
        mSharedPref.edit().apply {
            putInt(key, value)
            apply()
        }
    }

    fun read(key: String, defValue: Long) =
        mSharedPref.getLong(key, defValue)

    fun write(key: String, value: Long){
        mSharedPref.edit().apply {
            putLong(key, value)
            apply()
        }
    }

    fun clear(){
        mSharedPref.edit().clear().apply()
    }

}