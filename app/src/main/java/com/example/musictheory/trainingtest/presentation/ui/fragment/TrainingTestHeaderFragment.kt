package com.example.musictheory.trainingtest.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.musictheory.databinding.FragmentTrainingTestHeaderBinding
import com.example.musictheory.trainingtest.presentation.ui.viewmodel.TrainingTestViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

/**
 * A simple [Fragment] subclass.
 * Use the [TrainingTestHeaderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class TrainingTestHeaderFragment : Fragment() {
    private val trainingTestViewModel: TrainingTestViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTrainingTestHeaderBinding.inflate(layoutInflater)

        lifecycleScope.launchWhenCreated {
            trainingTestViewModel.questionString
                .collect {
                    /** Почему-то не отслеживает изменения
                     * Пробовал разные варианты, например брать lifecycle вью модели,
                     * менял на SharedStateFlow, но результат один.
                     */
                    binding.textviewQuestionHeader.text = it
                    Toast.makeText(context, "header text $it", Toast.LENGTH_SHORT).show()
                }
        }

        return binding.root
    }
}
