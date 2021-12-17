package com.example.musictheory.trainingtest.presentation.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musictheory.databinding.ItemTrainingTestBodyBinding
import com.example.musictheory.trainingtest.presentation.ui.list.viewholder.OnItemClickListener
import com.example.musictheory.trainingtest.presentation.ui.list.viewholder.ViewHolderTrainingTestBody

/**
 * @author Владислав Хвесюк 31.10.2021
 */

class AdapterTrainingTestBody(
    onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<ViewHolderTrainingTestBody>() {

    var data = listOf<String>()

    private var mOnItemClickListener: OnItemClickListener = onItemClickListener

//    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
//        mOnItemClickListener = onItemClickListener
//    }

    fun updateData(list: List<String>) {
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTrainingTestBody {
        val binding = ItemTrainingTestBodyBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolderTrainingTestBody(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderTrainingTestBody, position: Int) {
        holder.bind(data[position], mOnItemClickListener)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
