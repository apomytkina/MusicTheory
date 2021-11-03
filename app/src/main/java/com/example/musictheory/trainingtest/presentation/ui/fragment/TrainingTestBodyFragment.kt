package com.example.musictheory.trainingtest.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musictheory.databinding.FragmentTrainingTestBodyBinding
import com.example.musictheory.trainingtest.presentation.model.Answer
import com.example.musictheory.trainingtest.presentation.ui.list.adapter.AdapterTrainingTestBody

/**
 * A simple [Fragment] subclass.
 * Use the [TrainingTestBodyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TrainingTestBodyFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTrainingTestBodyBinding.inflate(inflater)
        binding.signList.layoutManager = LinearLayoutManager(context)
        val adapter = AdapterTrainingTestBody()
        adapter.updateData(mutableListOf(Answer("1"), Answer("2")))
        binding.signList.adapter = adapter

        return binding.root

//        return inflater.inflate(R.layout.fragment_training_test_body, container, false)
    }
}
