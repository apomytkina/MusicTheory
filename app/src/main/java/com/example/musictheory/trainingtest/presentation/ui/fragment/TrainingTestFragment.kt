package com.example.musictheory.trainingtest.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.lifecycleScope
import com.example.musictheory.R
import com.example.musictheory.core.data.MainActivityCallback
import com.example.musictheory.core.data.model.ServerResponse
import com.example.musictheory.databinding.TrainingTestFragmentBinding
import com.example.musictheory.trainingtest.presentation.ui.viewmodel.TrainingTestViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrainingTestFragment : Fragment() {

    private val trainingTestViewModel: TrainingTestViewModel
    by hiltNavGraphViewModels<TrainingTestViewModel>(R.id.nested_navigation_training_test)
    private var _binding: TrainingTestFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = TrainingTestFragmentBinding.inflate(inflater)

        initNestedFragments()

        // Вызов запроса к серверу через view model
        lifecycleScope.launch {
            val tests = async { trainingTestViewModel.getTests() }
//            val post = async { trainingTestViewModel.postTest() }
            trainingTestViewModel.getData(tests.await())
//            showDataFromServer(tests.await())
        }


        viewLifecycleOwner.lifecycleScope.launch {
            trainingTestViewModel.goNextEvent
                .collect {
                    if (it) {
                        var nextBodyFragment: Fragment? = null
                        when (trainingTestViewModel.displayedElements.value) {
                            "none" -> {
                                nextBodyFragment =
                                    TrainingTestBodyWithStaveFragment()
                            }
                            "stave" -> {
                                nextBodyFragment =
                                    TrainingTestBodyWithStaveFragment()
                            }
                        }
                        if (nextBodyFragment != null) {
                            childFragmentManager.commit {
                                replace(
                                    R.id.bodyTrainingTest,
                                    nextBodyFragment
                                )
                            }
                        }
                    }
                }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            trainingTestViewModel.goResultEvent
                .collect {
                    if (it != 0L) {
                        parentFragmentManager.beginTransaction().apply {
                            replace(R.id.full, ResultFragment.newInstance(it))
                            commit()
                        }
                    }
                }
        }
        return binding.root
    }

    private fun initNestedFragments() {
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
