package com.example.musictheory.account.student.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.musictheory.R
import com.example.musictheory.account.student.registration.StudentRegistrationFragment
import com.example.musictheory.account.student.viewmodel.PersonalAccountViewModel
import com.example.musictheory.databinding.FragmentStudentPersonalAccountLoginBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class StudentPersonalAccountLoginFragment : Fragment() {
    private val personalAccountViewModel: PersonalAccountViewModel
    by hiltNavGraphViewModels<PersonalAccountViewModel>(R.id.nested_personal_account)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentStudentPersonalAccountLoginBinding.inflate(inflater)
        initNestedFragments()
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.RESUMED) {

                personalAccountViewModel.goRegister.collect {
                    if (it) {
                        val studentRegistrationFragment = StudentRegistrationFragment()
                        childFragmentManager.beginTransaction().apply {
                            replace(R.id.login_body, studentRegistrationFragment)
                            commit()
                        }
                    }
                }
            }
        }
        return binding.root
//        return inflater.inflate(R.layout.fragment_student_personal_account_login, container, false)
    }
    private fun initNestedFragments() {
        val studentLoginFragment = StudentLoginFragment()
        childFragmentManager.beginTransaction().apply {
            add(R.id.login_body, studentLoginFragment)
            commit()
        }
    }
}
