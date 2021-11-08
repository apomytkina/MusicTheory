package com.example.musictheory.home.home_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.musictheory.databinding.TestCategoryCardBinding
import com.example.musictheory.home.home_model.Category
import com.example.musictheory.home.differCallback

class CategoriesAdapter :
    ListAdapter<Category, CategoriesViewHolder>(differCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder(
            TestCategoryCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
