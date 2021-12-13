package com.example.musictheory.account.account

import android.app.Activity
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.musictheory.R
import com.example.musictheory.core.data.MainActivityCallback
import com.example.musictheory.core.presenter.ThemeManager
import com.example.musictheory.databinding.AccountFragmentBinding

class AccountFragment : Fragment() {

    private val nightMode = "NIGHT_MODE"


    private lateinit var viewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = AccountFragmentBinding.inflate(inflater)

        binding.buttonChangeThemeAccount.setOnClickListener{
            val sharedName = "SharedPref"
            val settings = this.parentFragment?.activity?.getSharedPreferences(sharedName, 0)
            val editor = settings?.edit()
            when(settings?.getString(nightMode, "none")){
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
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AccountViewModel::class.java)
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