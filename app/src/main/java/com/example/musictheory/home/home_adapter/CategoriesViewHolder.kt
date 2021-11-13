package com.example.musictheory.home.home_adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.musictheory.databinding.TestCategoryCardBinding
import com.example.musictheory.home.home_model.Collection

class CategoriesViewHolder(private val binding: TestCategoryCardBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(data: Collection) {
        with(binding) {
            categoryTitle.text = data.name
        }
    }
}
