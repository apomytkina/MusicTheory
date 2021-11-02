package com.example.musictheory.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.musictheory.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        // val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.categories.observe(
            viewLifecycleOwner,
            Observer {
                // textView.text = it
            }
        )

        val homeHeaderFragment = HomeHeaderFragment()
        childFragmentManager.beginTransaction().apply {
            add(R.id.home_header, homeHeaderFragment)
            commit()
        }

        val homeBodyFragment = HomeBodyFragment()
        childFragmentManager.beginTransaction().apply {
            add(R.id.home_body, homeBodyFragment)
            commit()
        }

        val homeFooterFragment = HomeFooterFragment()
        childFragmentManager.beginTransaction().apply {
            add(R.id.home_footer, homeFooterFragment)
            commit()
        }

        return root
    }
}
