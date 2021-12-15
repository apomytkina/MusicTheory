package com.example.musictheory.home.homeAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.musictheory.databinding.TestCategoryCardBinding
import com.example.musictheory.trainingtest.data.model.MusicTest

class CategoriesViewHolder(
    private val binding: TestCategoryCardBinding,
    listener: CategoriesAdapter.OnItemClickListener
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(data: MusicTest) {
        with(binding) {
            categoryTitle.text = data.testName
        }
    }

    init {
        itemView.setOnClickListener {
            listener.onItemClick(adapterPosition)
        }
    }
}
