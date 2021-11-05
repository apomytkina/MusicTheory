package com.example.musictheory.trainingtest.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musictheory.R
import com.example.musictheory.databinding.FragmentResultBinding
import com.example.musictheory.model.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.progress.numStars = 5
        binding.progress.progress = 2
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setData(result: Result) {

    }

    companion object {

        private const val ARG_ID_RESULT = "id_result"

        fun newInstance(idResult: Int): Fragment {
            return ResultFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_ID_RESULT, idResult)
                }
            }
        }
    }
}