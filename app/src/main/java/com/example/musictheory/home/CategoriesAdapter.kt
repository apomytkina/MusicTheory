package com.example.musictheory.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musictheory.databinding.TestCategoryCardBinding

private val differCallback = object : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}

class CategoriesAdapter :
    ListAdapter<Category, CategoriesAdapter.CategoriesViewHolder>(differCallback) {

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

    class CategoriesViewHolder(private val binding: TestCategoryCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Category) {
            with(binding) {
                categoryTitle.text = data.title
            }
        }
    }
}
