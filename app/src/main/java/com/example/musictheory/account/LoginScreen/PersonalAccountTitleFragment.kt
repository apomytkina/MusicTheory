package com.example.musictheory.account.LoginScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.musictheory.databinding.FragmentPersonalAccountTitleBinding

class PersonalAccountTitleFragment : Fragment() {
    private var _binding: FragmentPersonalAccountTitleBinding? = null
    private val binding get() = _binding!!

    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPersonalAccountTitleBinding.inflate(inflater, container, false)
        val view = binding.root

//        backButton = binding.backButton
//        backButton.setOnClickListener {
//            requireActivity().fragmentManager.popBackStack()
//        }

        return view
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
