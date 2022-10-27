package com.tariqul.alet.presentation.fragment.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tariqul.alet.UiText

abstract class BaseViewModel : ViewModel() {


    companion object {
        const val TAG = "BaseViewModel"
    }

    protected val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    protected val _error = MutableLiveData<UiText?>()
    val error: LiveData<UiText?>
        get() = _error

    protected val _fieldName = MutableLiveData<String?>()
    val fieldName: LiveData<String?>
        get() = _fieldName

    fun updateLoading(isLoading: Boolean) {
        _isLoading.postValue(isLoading)
    }


}