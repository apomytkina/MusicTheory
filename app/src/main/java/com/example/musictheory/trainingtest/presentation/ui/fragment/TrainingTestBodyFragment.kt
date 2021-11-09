package com.example.musictheory.trainingtest.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musictheory.databinding.FragmentTrainingTestBodyBinding
import com.example.musictheory.trainingtest.presentation.ui.list.adapter.AdapterTrainingTestBody
import com.example.musictheory.trainingtest.presentation.ui.viewmodel.TrainingTestViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

/**
 * A simple [Fragment] subclass.
 * Use the [TrainingTestBodyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class TrainingTestBodyFragment : Fragment() {

    private val trainingTestViewModel: TrainingTestViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTrainingTestBodyBinding.inflate(inflater)
        binding.signList.layoutManager = LinearLayoutManager(context)
        val adapter = AdapterTrainingTestBody()
        adapter.updateData(listOf("1", "2"))
        binding.signList.adapter = adapter

        lifecycleScope.launchWhenCreated {
            trainingTestViewModel.answersList
                .collect {
                    /** Почему-то не отслеживает изменения
                     * Пробовал разные варианты, например брать lifecycle вью модели,
                     * менял на SharedStateFlow, но результат один.
                     */
                    adapter.updateData(it)
                }
        }

        return binding.root
    }
}
