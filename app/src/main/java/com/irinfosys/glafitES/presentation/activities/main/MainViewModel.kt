package com.irinfosys.glafitES.presentation.activities.main

import com.irinfosys.glafitES.lang.LanguageProvider
import com.irinfosys.glafitES.presentation.fragment.base.BaseViewModel
import com.irinfosys.glafitES.util.UserFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userFactory: UserFactory,
    private val languageProvider: LanguageProvider
) : BaseViewModel() {


    fun hasLoggedIn(): Boolean = userFactory.getAccessToken().isNotEmpty()

    fun doLogout() {
        userFactory.clear()
    }





}