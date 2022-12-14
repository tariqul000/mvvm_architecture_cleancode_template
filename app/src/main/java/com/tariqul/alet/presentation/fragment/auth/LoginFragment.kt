package com.tariqul.alet.presentation.fragment.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import com.tariqul.alet.*
import com.tariqul.alet.databinding.FragmentLoginBinding
import com.tariqul.alet.lang.LanguageChangeListener
import com.tariqul.alet.lang.LanguageProvider
import com.tariqul.alet.presentation.activities.main.MainActivity
import com.tariqul.alet.presentation.fragment.base.BaseFragment
import com.tariqul.alet.view.hide
import com.tariqul.alet.view.isVisible
import com.tariqul.alet.view.show
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>(
    R.layout.fragment_login
) {

    @Inject
    lateinit var languageProvider: LanguageProvider

    private var languageChangeListener: LanguageChangeListener? = null
    companion object {
        private const val TAG = "LoginFragment"
    }
    override val viewModel by viewModels<LoginViewModel>()

    override fun initializeViewBinding(view: View) = FragmentLoginBinding.bind(view)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            languageChangeListener = context as LanguageChangeListener?
        } catch (e: Exception) {
            Log.e(TAG, "onAttach: ${e.message}")
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSpinnerLanguageAdapter()
        setupListeners()
        subscribeObservers()

        if (BuildConfig.DEBUG) {
            binding.etEmail.setText("01957206205")
            binding.etPassword.setText("s1234")
        }
    }

    private fun setupListeners() {
        binding.etEmail.addTextChangedListener { text: Editable? ->
            text?.toString()?.let {
                viewModel.onLoginEvent(LoginFormEvent.PhoneChanged(it))
            }
        }

        binding.etPassword.addTextChangedListener { text: Editable? ->
            text?.toString()?.let {
                viewModel.onLoginEvent(LoginFormEvent.PasswordChanged(it))
            }
        }

        binding.btnLogin.setOnClickListener {
            viewModel.onLoginEvent(LoginFormEvent.Submit)
        }


    }
    override fun onDestroyView() {
        super.onDestroyView()
    }


    private fun subscribeObservers() {
        viewModel.error.observe(viewLifecycleOwner) { error ->
            if (error != null) {
                showError(error)
            } else {
                binding.tvError.hide()
            }
        }

        viewModel.validationEvent.observe(viewLifecycleOwner) { event ->
            when (event) {
                is ValidationEvent.Failure -> {
                    showError(event.text)
                }
                ValidationEvent.Success -> {
                    binding.tvError.text = ""
                    navigateToMainFragment()
                }
            }
        }
    }

    private fun showError(text: UiText) {
        binding.tvError.text = text.asString(requireContext())
        if (!binding.tvError.isVisible()) {
            binding.tvError.show()
        }
    }

    private fun navigateToMainFragment() {
        requireActivity().startActivity(
            Intent(requireActivity(), MainActivity::class.java)
        )
        requireActivity().finish()
    }

    private fun setupSpinnerLanguageAdapter() {
        ArrayAdapter(
            requireActivity(),
            android.R.layout.simple_spinner_item,
            arrayOf("English", "???????????????")
        ).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spLanguage.adapter = it
        }

        binding.spLanguage.setSelection(
            getLanguagePosition()
        )

        binding.spLanguage.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val langCode = if (position == 0) {
                    LanguageProvider.LANG_CODE_EN
                } else {
                    LanguageProvider.LANG_CODE_BN
                }
                if (languageProvider.getCurrentLanguage() != langCode) {
                    languageChangeListener?.onLanguageChange(langCode)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) = Unit
        }

    }


    private fun getLanguagePosition(): Int {
        return if (languageProvider.getCurrentLanguage() == LanguageProvider.LANG_CODE_EN) 0 else 1
    }

}