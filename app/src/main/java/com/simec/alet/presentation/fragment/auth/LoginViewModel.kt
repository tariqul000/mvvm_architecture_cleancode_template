package com.simec.alet.presentation.fragment.auth

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultCallback
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.simec.alet.Resource
import com.simec.alet.ValidationEvent
import com.simec.alet.data.remote.request.LoginRequest
import com.simec.alet.domain.repository.AuthRepository
import com.simec.alet.domain.usecase.ValidateEmail
import com.simec.alet.domain.usecase.ValidatePassword
import com.simec.alet.domain.usecase.ValidatePhone
import com.simec.alet.domain.usecase.ValidateSocialType
import com.simec.alet.presentation.fragment.base.BaseViewModel
import com.simec.alet.util.UserFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val validatePhone: ValidatePhone,
    private val validatePassword: ValidatePassword,
    private val repository: AuthRepository,
    private val userFactory: UserFactory,
) : BaseViewModel() {

    private val phone = MutableLiveData<String>()
    private val password = MutableLiveData<String>()


    private val _validationEvent = MutableLiveData<ValidationEvent>()
    val validationEvent: LiveData<ValidationEvent>
        get() = _validationEvent

    fun onLoginEvent(event: LoginFormEvent) {
        when (event) {
            is LoginFormEvent.PhoneChanged -> {
                phone.value = event.phone
            }
            is LoginFormEvent.PasswordChanged -> {
                password.value = event.password
            }
            LoginFormEvent.Submit -> {
                doLogin()
            }
        }
    }

    private fun doLogin() {
        val emailResult = validatePhone(phone.value ?: "")
        val passwordResult = validatePassword(password.value ?: "")

        if (!emailResult.isSuccessful) {
            _error.postValue(emailResult.errorMessage)
            return
        }

        if (!passwordResult.isSuccessful) {
            _error.postValue(passwordResult.errorMessage)
            return
        }

        val loginRequest = LoginRequest(
            phone = phone.value ?: "",
            password = password.value ?: ""
        )
        viewModelScope.launch {
            when (val resource = repository.doSignIn(
                loginRequest
            )) {

                is Resource.Failure -> {
                    Log.d("repository ",""+resource.text);
                    updateLoading(false)
                    _validationEvent.postValue(
                        ValidationEvent.Failure(
                            resource.text,
                            resource.code

                        )
                    )
                }
                is Resource.Loading -> {
                    updateLoading(true)
                }
                is Resource.Success -> {
                    Log.d("repository ",""+ resource.data.toString());
                    updateLoading(false)
                    saveTokenAndRequest(
                        resource.data.data.accessToken,
                        loginRequest,
                        UserFactory.TYPE_CREDENTIAL
                    )
                    _validationEvent.postValue(ValidationEvent.Success)
                }
            }
        }
    }


    private fun saveTokenAndRequest(
        token: String,
        loginRequest: LoginRequest,
        type: String
    ) {
        userFactory.saveAccessToken(token)
        userFactory.saveLoginType(type)
        userFactory.saveLoginRequest(loginRequest)
    }


}