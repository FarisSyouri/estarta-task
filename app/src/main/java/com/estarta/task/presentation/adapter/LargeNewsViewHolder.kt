package com.estarta.task.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.estarta.task.databinding.ItemLayoutBinding
import com.estarta.task.domain.model.Item

class LargeNewsViewHolder(
    private val binding: ItemLayoutBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item) {
        binding.item = item
    }
}