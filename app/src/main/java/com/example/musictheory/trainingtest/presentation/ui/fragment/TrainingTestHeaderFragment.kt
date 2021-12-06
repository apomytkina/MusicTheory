package com.example.musictheory.trainingtest.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.lifecycleScope
import com.example.musictheory.R
import com.example.musictheory.databinding.FragmentTrainingTestHeaderBinding
import com.example.musictheory.trainingtest.presentation.ui.viewmodel.TrainingTestViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 * Use the [TrainingTestHeaderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class TrainingTestHeaderFragment : Fragment() {
    private val trainingTestViewModel: TrainingTestViewModel
    by hiltNavGraphViewModels<TrainingTestViewModel>(R.id.nested_navigation_training_test)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTrainingTestHeaderBinding.inflate(layoutInflater)

        viewLifecycleOwner.lifecycleScope.launch {
            trainingTestViewModel.questionString
                .collect {
                    binding.textviewQuestionHeader.text = it
                }
        }

        return binding.root
    }
}
