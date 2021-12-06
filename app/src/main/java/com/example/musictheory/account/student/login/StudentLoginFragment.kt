package com.example.musictheory.account.student.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.musictheory.databinding.FragmentStudentLoginBinding

class StudentLoginFragment : Fragment() {
    private var _binding: FragmentStudentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var loginEditText: EditText
    private lateinit var passwordEditText: EditText

    private lateinit var enterButton: Button
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStudentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        loginEditText = binding.loginEt
        passwordEditText = binding.passwordEt
        enterButton = binding.enterButton
        registerButton = binding.registerButton

        enterButton.setOnClickListener {
        }

        registerButton.setOnClickListener {
        }

        return view
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
