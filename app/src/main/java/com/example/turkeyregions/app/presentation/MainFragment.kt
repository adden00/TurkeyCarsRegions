package com.example.turkeyregions.app.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.turkeyregions.app.Constants
import com.example.turkeyregions.app.presentation.search_by_code_screen.SearchByCodeFragment
import com.example.turkeyregions.app.presentation.search_by_name_screen.SearchByNameFragment
import com.example.turkeyregions.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpUI()


    }

    private fun setUpUI() {
        binding.vpTabs.adapter =
            PagesAdapter(
                requireActivity(),
                listOf(SearchByCodeFragment(), SearchByNameFragment())
            )
        TabLayoutMediator(binding.tbPages, binding.vpTabs) { tab, pos ->
            tab.text = Constants.TAB_LAYOUT_PAGES[pos]
        }.attach()


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}