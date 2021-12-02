package com.example.musictheory.trainingtest.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.lifecycleScope
import com.example.musictheory.R
import com.example.musictheory.databinding.FragmentTrainingTestBodyWithStaveBinding
import com.example.musictheory.model.Mistake
import com.example.musictheory.model.Result
import com.example.musictheory.model.Test
import com.example.musictheory.model.TypeQuestion
import com.example.musictheory.trainingtest.presentation.ui.list.adapter.AdapterTrainingTestBody
import com.example.musictheory.trainingtest.presentation.ui.list.viewholder.OnItemClickListener
import com.example.musictheory.trainingtest.presentation.ui.viewmodel.TrainingTestViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * A simple [Fragment] subclass.
 * Use the [TrainingTestBodyWithStaveFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class TrainingTestBodyWithStaveFragment : Fragment(), OnItemClickListener {

    private val trainingTestViewModel: TrainingTestViewModel
    by hiltNavGraphViewModels<TrainingTestViewModel>(R.id.nested_navigation_training_test)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTrainingTestBodyWithStaveBinding.inflate(inflater)
        val adapter = AdapterTrainingTestBody(this)

//        adapter.updateData(listOf("1", "2"))
        binding.signList.adapter = adapter

        lifecycleScope.launchWhenResumed {
            trainingTestViewModel.answersList
                .collect {
                    adapter.updateData(it)
                }
        }

        return binding.root
    }

    override fun onItemClick(item: String) {
        trainingTestViewModel.saveTest(
            Test(
                trainingTestViewModel.serverResponseCollection.value.id.oid,
                idCategory = 0,
                questions = listOf("are you "),
                answers = listOf("yes"),
                typeOfQuestion = TypeQuestion.SIMPLE
            )
        )
        lifecycleScope.launch {
            val id = withContext(Dispatchers.IO) {
                trainingTestViewModel.saveResult(
                    Result(
                        idTest = trainingTestViewModel.serverResponseCollection.value.id.oid,
                        mistakeCount = 1,
                        mistakeArray = listOf(Mistake(1, listOf("ошибка", "ошибка")))
                    )
                )
            }
            trainingTestViewModel.goResult(id)
        }
    }
}
