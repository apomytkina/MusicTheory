package com.example.musictheory.home.homeAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.musictheory.databinding.TestCategoryCardBinding
import com.example.musictheory.home.differCallback
import com.example.musictheory.home.homeModel.Collection

class CategoriesAdapter :
    ListAdapter<Collection, CategoriesViewHolder>(differCallback) {
    private lateinit var listener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(setListener: OnItemClickListener) {
        listener = setListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder(
            TestCategoryCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
            listener
        )
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
