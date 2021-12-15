package com.example.musictheory.account.presenter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.example.musictheory.R
import com.example.musictheory.account.presenter.viewmodels.PersonalAccountViewModel
import com.example.musictheory.core.data.MainActivityCallback
import com.example.musictheory.core.presenter.ThemeManager
import com.example.musictheory.databinding.AccountFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountFragment : Fragment() {

    private val nightMode = "NIGHT_MODE"

    private val personalAccountViewModel: PersonalAccountViewModel
    by hiltNavGraphViewModels<PersonalAccountViewModel>(R.id.nested_personal_account)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = AccountFragmentBinding.inflate(inflater)

        binding.textViewAccountName.text = personalAccountViewModel.email.value?.name
        when (personalAccountViewModel.email.value?.role) {
            null -> {
                binding.buttonAddTestAccount.visibility = View.GONE
            }
            "teacher" -> {
                binding.buttonAddTestAccount.visibility = View.VISIBLE
            }
            else -> {
                binding.buttonAddTestAccount.visibility = View.GONE
            }
        }

        binding.buttonChangeThemeAccount.setOnClickListener {
            val sharedName = "SharedPref"
            val settings = this.parentFragment?.activity?.getSharedPreferences(sharedName, 0)
            val editor = settings?.edit()
            when (settings?.getString(nightMode, "none")) {
                "light" -> {
                    toggleTheme(false)
                    editor?.putString(nightMode, "dark")
                    editor?.apply()
                }
                "dark" -> {
                    toggleTheme(true)
                    editor?.putString(nightMode, "light")
                    editor?.apply()
                }
            }
        }

        binding.buttonAddTestAccount.setOnClickListener {
            if (activity is MainActivityCallback) {
                (activity as MainActivityCallback).goAddTestFragment()
            }
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity is MainActivityCallback) {
            (activity as MainActivityCallback).hideBottomNavigationView()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (activity is MainActivityCallback) {
            (activity as MainActivityCallback).showBottomNavigationView()
        }
    }

    private fun toggleTheme(isDark: Boolean): Boolean {

        val mode = when (isDark) {
            true -> ThemeManager.LIGHT_MODE
            false -> ThemeManager.DARK_MODE
        }
        ThemeManager.applyTheme(mode)

        return true
    }
}
