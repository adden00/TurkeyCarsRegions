package com.example.turkeyregions.app.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagesAdapter(activity: FragmentActivity, private val fragmentList: List<Fragment>) :
    FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = fragmentList.size
    override fun createFragment(position: Int): Fragment = fragmentList[position]
}