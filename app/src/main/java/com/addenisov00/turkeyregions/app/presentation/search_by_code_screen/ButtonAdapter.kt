package com.addenisov00.turkeyregions.app.presentation.search_by_code_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.addenisov00.turkeyregions.R
import com.addenisov00.turkeyregions.databinding.ButtonItemBinding

class ButtonAdapter(private val listener: Listener) :
    ListAdapter<String, ButtonAdapter.ItemHolder>(object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
            oldItem == newItem

    }) {
    inner class ItemHolder(private val binding: ButtonItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(item: String) {
            binding.btn.text = item
            binding.btn.setOnClickListener {
                listener.onClick(item)
            }
            if (item == "C")
                binding.btn.setTextColor(binding.root.context.getColor(R.color.red))
            else
                binding.btn.setTextColor(binding.root.context.getColor(R.color.main_text_color))
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder = ItemHolder(
        ButtonItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(getItem(position))
    }

    interface Listener {
        fun onClick(item: String)
    }
}