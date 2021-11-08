package com.example.musictheory.home

import androidx.recyclerview.widget.DiffUtil
import com.example.musictheory.home.home_model.Category

val differCallback = object : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}
