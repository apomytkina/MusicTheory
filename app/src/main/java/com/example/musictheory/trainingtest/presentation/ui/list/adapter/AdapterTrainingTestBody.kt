package com.example.musictheory.trainingtest.presentation.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musictheory.databinding.ItemTrainingTestBodyBinding
import com.example.musictheory.trainingtest.presentation.model.Answer
import com.example.musictheory.trainingtest.presentation.ui.list.viewholder.ViewHolderTrainingTestBody

/**
 * @author Владислав Хвесюк 31.10.2021
 */

class AdapterTrainingTestBody : RecyclerView.Adapter<ViewHolderTrainingTestBody>() {

    var data = mutableListOf<Answer>()

    fun updateData(list: MutableList<Answer>) {
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
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
