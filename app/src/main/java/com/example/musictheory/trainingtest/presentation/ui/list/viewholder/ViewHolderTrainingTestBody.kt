package com.example.musictheory.trainingtest.presentation.ui.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.musictheory.databinding.ItemTrainingTestBodyBinding
import com.example.musictheory.trainingtest.presentation.model.Answer

/**
 * @author Владислав Хвесюк 31.10.2021
 */

class ViewHolderTrainingTestBody(
    private val binding: ItemTrainingTestBodyBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(answer: Answer) {
        binding.buttonItemTrainingTestBody.text = answer.strValue
    }
}
