package com.example.musictheory.home.homeFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musictheory.R
import com.example.musictheory.databinding.FragmentHomeBodyBinding
import com.example.musictheory.home.homeAdapter.CategoriesAdapter
import com.example.musictheory.home.homeViewModel.HomeViewModel
import com.example.musictheory.trainingtest.presentation.ui.fragment.TrainingTestFragment

class HomeBodyFragment : Fragment() {
    lateinit var categoriesAdapter: CategoriesAdapter
    lateinit var homeViewModel: HomeViewModel

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
        categoriesAdapter = CategoriesAdapter()

        setUpRecyclerView()

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

    private fun setUpRecyclerView() {
        var adapter = CategoriesAdapter()
        binding.testCategoryRecyclerView.apply {
            adapter
            layoutManager = LinearLayoutManager(activity)
        }
        adapter.setOnItemClickListener(
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
    }
}
