package com.example.musictheory.home

import androidx.recyclerview.widget.DiffUtil
import com.example.musictheory.home.homeModel.Collection

val differCallback = object : DiffUtil.ItemCallback<Collection>() {
    override fun areItemsTheSame(oldItem: Collection, newItem: Collection): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Collection, newItem: Collection): Boolean {
        return oldItem == newItem
    }
}
