package com.example.musictheory.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.musictheory.R
import com.example.musictheory.databinding.TestCategoryCardBinding
import androidx.recyclerview.widget.ListAdapter

private val differCallback = object : DiffUtil.ItemCallback<Category>(){
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}

class CategoriesAdapter: ListAdapter<Category, CategoriesAdapter.CategoriesViewHolder>(differCallback) {
    lateinit var binding1: TestCategoryCardBinding
    val differ = AsyncListDiffer(this, differCallback)

    inner class CategoriesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.test_category_card, parent, false)
        val binding1 = TestCategoryCardBinding.bind(view)
        return CategoriesViewHolder(binding1.root)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val category = differ.currentList[position]

        holder.itemView.apply {
            binding1.categoryTitle.text = category.title
        }
    }
}