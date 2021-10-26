package com.example.musictheory.trainingtest.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musictheory.R
import com.example.musictheory.databinding.FragmentTrainingTestBodyBinding
import com.example.musictheory.databinding.TrainingTestFragmentBinding
import dagger.hilt.android.AndroidEntryPoint


/**
 * A simple [Fragment] subclass.
 * Use the [TrainingTestBodyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TrainingTestBodyFragment : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment


        val binding  = FragmentTrainingTestBodyBinding.inflate(inflater)
        return binding.root

//        return inflater.inflate(R.layout.fragment_training_test_body, container, false)
    }

}