package com.example.musictheory.trainingtest.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.musictheory.R
import com.example.musictheory.databinding.FragmentResultBinding
import com.example.musictheory.model.Mistake
import com.example.musictheory.model.Result
import com.example.musictheory.model.Test
import com.example.musictheory.model.TypeQuestion
import com.example.musictheory.trainingtest.presentation.ui.viewmodel.ResultViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : Fragment() {

    private val viewModel: ResultViewModel by viewModels()
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.result.observe(
            viewLifecycleOwner,
            { result ->
                getTest(result)
            }
        )

        arguments?.let {
            val id = it.getInt(ARG_ID_RESULT)
            viewModel.getResultById(id)
        }
    }
    private fun insertTestData() {
        viewModel.saveTest(Test(0, 0, listOf("are you "), listOf("yes"), TypeQuestion.SIMPLE))
        viewModel.saveResult(Result(1, 0, 1, listOf(Mistake(1, listOf("ошибка", "ошибка")))))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getTest(result: Result) {
        viewModel.test.observe(
            viewLifecycleOwner,
            { test ->
                setData(result, test)
            }
        )
        viewModel.getTestById(result.idTest)
    }

    private fun setData(result: Result, test: Test) {
        val allCount = test.questions.size
        binding.tvCorrectCount.text = requireContext().getString(
            R.string.result_from,
            (allCount - result.mistakeCount),
            allCount
        )
        binding.progress.progress = (allCount - result.mistakeCount) / allCount
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
