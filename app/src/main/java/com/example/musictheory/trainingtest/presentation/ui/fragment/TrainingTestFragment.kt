package com.example.musictheory.trainingtest.presentation.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.musictheory.databinding.TrainingTestFragmentBinding
import com.example.musictheory.trainingtest.presentation.ui.viewmodel.TrainingTestViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class TrainingTestFragment : Fragment() {


    private lateinit var trainingTestViewModel: TrainingTestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = TrainingTestFragmentBinding.inflate(inflater)
        trainingTestViewModel = ViewModelProvider(this).get(TrainingTestViewModel::class.java)
        binding.lifecycleOwner = this

        trainingTestViewModel.messageHello
            .onEach {
                binding.txtTrainingTestHello.text= ".$it."
            }
            .launchIn(lifecycleScope)
        return binding.root
    }


}