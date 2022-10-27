package com.simec.alet.presentation.activities.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.simec.alet.activity.startWithNewTask
import com.simec.alet.lang.LanguageChangeListener
import com.simec.alet.lang.LanguageContextWrapper
import com.simec.alet.lang.LanguageProvider
import com.simec.alet.presentation.MyApp


abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity(), LanguageChangeListener {

    protected lateinit var binding: VB

    private lateinit var languageProvider: LanguageProvider

    companion object {
        const val TAG = "BaseActivity"
    }

    override fun attachBaseContext(newBase: Context?) {
        if (newBase != null) {
            languageProvider = (newBase.applicationContext as MyApp).languageProvider
            val lang = languageProvider.getCurrentLanguage()
            super.attachBaseContext(LanguageContextWrapper.wrap(newBase, lang))
        } else {
            super.attachBaseContext(newBase)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = initializeViewBinding()
        setContentView(binding.root)
    }

    override fun onLanguageChange(language: String) {
        languageProvider.setCurrentLanguage(language)
        finish()
        startWithNewTask(intent)
    }


    abstract fun initializeViewBinding(): VB


}