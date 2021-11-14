package com.example.musictheory.home.home_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musictheory.databinding.FragmentHomeBodyBinding
import com.example.musictheory.home.homeAdapter.CategoriesAdapter
import com.example.musictheory.home.homeViewModel.HomeViewModel

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
        setUpRecyclerView()

        homeViewModel.categories.observe(
            viewLifecycleOwner,
            Observer { response ->
                binding.apply {
                }
            }
        )

        return view
    }

    private fun setUpRecyclerView() {
        categoriesAdapter = CategoriesAdapter()
        binding.testCategoryRecyclerView.apply {
            adapter = categoriesAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}
