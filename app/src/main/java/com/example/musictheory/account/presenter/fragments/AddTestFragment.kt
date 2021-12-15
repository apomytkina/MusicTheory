package com.example.musictheory.account.presenter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.lifecycleScope
import com.example.musictheory.R
import com.example.musictheory.account.presenter.viewmodels.PersonalAccountViewModel
import com.example.musictheory.databinding.AddTestFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber
@AndroidEntryPoint
class AddTestFragment : Fragment() {

    companion object {
        fun newInstance() = AddTestFragment()
    }

//    private lateinit var viewModel: AddTestViewModel
    private val personalAccountViewModel: PersonalAccountViewModel
    by hiltNavGraphViewModels<PersonalAccountViewModel>(R.id.nested_personal_account)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = AddTestFragmentBinding.inflate(inflater)

        binding.buttonAddTestAccount.setOnClickListener {
            lifecycleScope.launch {
                Timber.v("t10 start ")
                val str = binding.editTextIncorrectAnswersAccount.text.toString()
                var strArray = str.split(", ")
                var answerArray = ArrayList<ArrayList<String>>()
                var tmpArray = arrayListOf(binding.editTextAnswerAccount.text.toString())
                tmpArray.addAll(strArray)
                answerArray.add(tmpArray)
                personalAccountViewModel.postTestToServer(
                    listOf(binding.editTextQuestionAccount.text.toString()),
                    answerArray,
                    listOf("none"),
                    binding.editTextTestNameAccount.text.toString()
                )
            }
        }

        binding.buttonDeleteTestAccount.setOnClickListener {
            lifecycleScope.launch {
                personalAccountViewModel.postDeleteTest()
            }
        }
        return binding.root
    }
}
