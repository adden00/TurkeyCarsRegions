package com.example.turkeyregions.app.presentation.search_by_name_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.turkeyregions.data.local.RegionNumberItem
import com.example.turkeyregions.databinding.RegionItemBinding

class RegionAdapter : ListAdapter<RegionNumberItem, RegionAdapter.ItemHolder>(object :
    DiffUtil.ItemCallback<RegionNumberItem>() {
    override fun areItemsTheSame(oldItem: RegionNumberItem, newItem: RegionNumberItem) =
        oldItem.regionNumber == newItem.regionNumber

    override fun areContentsTheSame(oldItem: RegionNumberItem, newItem: RegionNumberItem) =
        oldItem == newItem

}) {
    class ItemHolder(private val binding: RegionItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(item: RegionNumberItem) {
            binding.tvRegionName.text = item.regionName
            binding.tvRegionNumber.text = item.regionNumber
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemHolder(
        RegionItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(getItem(position))
    }
}