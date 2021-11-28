package com.example.musictheory.home.homeAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.musictheory.databinding.TestCategoryCardBinding
import com.example.musictheory.home.homeModel.Collection

class CategoriesViewHolder(
    private val binding: TestCategoryCardBinding,
    listener: CategoriesAdapter.OnItemClickListener
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: Collection) {
        with(binding) {
            categoryTitle.text = data.name
        }
    }

    init {
        itemView.setOnClickListener {
            listener.onItemClick(adapterPosition)
        }
    }
}
