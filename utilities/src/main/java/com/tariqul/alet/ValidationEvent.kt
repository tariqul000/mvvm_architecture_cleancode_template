package com.tariqul.alet

sealed class ValidationEvent {
    object Success : ValidationEvent()
    data class Failure(val text: UiText, val code: Int): ValidationEvent()
}