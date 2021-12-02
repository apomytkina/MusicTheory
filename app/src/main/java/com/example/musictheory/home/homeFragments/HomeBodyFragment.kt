package com.example.musictheory.home.homeFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musictheory.R
import com.example.musictheory.databinding.FragmentHomeBodyBinding
import com.example.musictheory.home.homeAdapter.CategoriesAdapter
import com.example.musictheory.home.homeViewModel.HomeViewModel
import com.example.musictheory.trainingtest.presentation.ui.fragment.TrainingTestFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeBodyFragment : Fragment() {
    lateinit var categoriesAdapter: CategoriesAdapter
//    lateinit var homeViewModel: HomeViewModel

    private val homeViewModel
    by hiltNavGraphViewModels<HomeViewModel>(R.id.nested_navigation_home)

    private var _binding: FragmentHomeBodyBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBodyBinding.inflate(inflater, container, false)
        val view = binding.root
        categoriesAdapter = CategoriesAdapter(
            object : CategoriesAdapter.OnItemClickListener {
                override fun onItemClick(position: Int) {
                    val bundle = Bundle()
                    bundle.putInt("categoryNumber", position)
                    val trainingTestFragment = TrainingTestFragment()
                    trainingTestFragment.arguments = bundle
                    fragmentManager?.beginTransaction()?.replace(
                        R.id.nav_host_fragment_container,
                        trainingTestFragment
                    )?.commit()
                }
            }
        )
        setUpRecyclerView(categoriesAdapter)

        homeViewModel.categories.observe(
            viewLifecycleOwner,
            Observer { response ->
                binding.apply {
                    categoriesAdapter.submitList(response)
                }
            }
        )

        return view
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun setUpRecyclerView(categoriesAdapter: CategoriesAdapter) {
        binding.testCategoryRecyclerView.apply {
            adapter = categoriesAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}
