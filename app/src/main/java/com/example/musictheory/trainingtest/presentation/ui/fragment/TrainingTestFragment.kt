package com.example.musictheory.trainingtest.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.musictheory.R
import com.example.musictheory.core.data.MainActivityCallback
import com.example.musictheory.core.data.model.ServerResponse
import com.example.musictheory.databinding.TrainingTestFragmentBinding
import com.example.musictheory.trainingtest.presentation.ui.viewmodel.TrainingTestViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class TrainingTestFragment : Fragment() {

//    private lateinit var trainingTestViewModel: TrainingTestViewModel

    private val trainingTestViewModel: TrainingTestViewModel by viewModels()
    private var _binding: TrainingTestFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = TrainingTestFragmentBinding.inflate(inflater)

        trainingTestViewModel.messageHello
            .onEach {
//                Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()
            }.launchIn(lifecycleScope)

        val trainingTestHeaderFragment = TrainingTestHeaderFragment()
        childFragmentManager.beginTransaction().apply {
            add(R.id.headerTrainingTest, trainingTestHeaderFragment)
            commit()
        }

        val trainingTestBodyFragment = TrainingTestBodyFragment()
        childFragmentManager.beginTransaction().apply {
            add(R.id.bodyTrainingTest, trainingTestBodyFragment)
            commit()
        }

        val trainingFragmentFooterFragment = TrainingTestFooterFragment()
        childFragmentManager.beginTransaction().apply {
            add(R.id.footerTrainingTest, trainingFragmentFooterFragment)
            commit()
        }

        if (activity is MainActivityCallback) {
            (activity as MainActivityCallback).hideBottomNavigationView()
        }
//        val navController = Navigation.findNavController(binding.root)

        // Вызов запроса к серверу через view model
        lifecycleScope.launch {
            val tests = async { trainingTestViewModel.getTests() }
//            async { trainingTestViewModel.postTest() }
            trainingTestViewModel.getData(tests.await())
            showDataFromServer(tests.await())
        }

        lifecycleScope.launchWhenCreated {
            trainingTestViewModel.questionString
                .collect() {
                    binding.textviewTest.text = it
                    Toast.makeText(context, " Получено с сервера$it", Toast.LENGTH_SHORT).show()
                }
        }

        return binding.root
    }

    private suspend fun showDataFromServer(
        serverResponse: ServerResponse
    ) = withContext(Dispatchers.Main) {
        Toast.makeText(
            context,
            "${serverResponse.data.collection.get(0).questionArray[0]}",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onPause() {
        super.onPause()
        if (activity is MainActivityCallback) {
            (activity as MainActivityCallback).showBottomNavigationView()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
