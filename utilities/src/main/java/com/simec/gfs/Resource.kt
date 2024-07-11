package com.simec.gfs

sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Loading(val nothing: Nothing? = null) : Resource<Nothing>()
    data class Failure(val text: UiText, val code: Int) : Resource<Nothing>()
}