package com.simec.alet.presentation.activities.main

import com.simec.alet.lang.LanguageProvider
import com.simec.alet.presentation.fragment.base.BaseViewModel
import com.simec.alet.util.UserFactory
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