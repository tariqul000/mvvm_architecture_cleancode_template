package com.simec.gfs.presentation.activities.main

import com.simec.gfs.lang.LanguageProvider
import com.simec.gfs.presentation.fragment.base.BaseViewModel
import com.simec.gfs.util.UserFactory
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