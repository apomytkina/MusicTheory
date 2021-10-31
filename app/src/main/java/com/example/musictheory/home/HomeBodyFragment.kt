package com.example.musictheory.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.musictheory.R
import com.example.musictheory.trainingtest.presentation.ui.fragment.TrainingTestHeaderFragment

class HomeBodyFragment : Fragment() {
    lateinit var categoriesAdapter: CategoriesAdapter
    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =  inflater.inflate(R.layout.fragment_home_body, container, false)

        setUpRecyclerView()

        return binding
    }

    private fun setUpRecyclerView(){
        categoriesAdapter = CategoriesAdapter()
        // rvTestCategories ?
    }
}