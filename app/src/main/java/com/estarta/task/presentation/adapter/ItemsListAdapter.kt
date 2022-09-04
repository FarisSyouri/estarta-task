package com.estarta.task.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.estarta.task.databinding.ItemLayoutBinding
import com.estarta.task.domain.model.Item
import com.estarta.task.presentation.utils.OnItemClickCallback

class ItemsListAdapter(
    private val itemsList: List<Item>,
    private val onItemClickCallback: OnItemClickCallback
) : RecyclerView.Adapter<LargeNewsViewHolder>() {

    private lateinit var binding: ItemLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LargeNewsViewHolder {
        binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LargeNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LargeNewsViewHolder, position: Int) {
        val item = itemsList[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(it, item, position)
        }
    }

    override fun getItemCount(): Int = itemsList.size

}

