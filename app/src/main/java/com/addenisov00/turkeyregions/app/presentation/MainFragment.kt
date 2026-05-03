package com.addenisov00.turkeyregions.app.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import com.addenisov00.turkeyregions.R
import com.addenisov00.turkeyregions.app.presentation.search_by_code_screen.SearchByCodeFragment
import com.addenisov00.turkeyregions.app.presentation.search_by_name_screen.SearchByNameFragment
import com.addenisov00.turkeyregions.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.math.max

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
        applySystemInsets()
        setUpUI()
    }

    private fun setUpUI() {
        val tabPages = listOf(
            getString(R.string.code_to_region),
            getString(R.string.region_to_code),
        )
        binding.vpTabs.adapter =
            PagesAdapter(
                requireActivity(),
                listOf(SearchByCodeFragment(), SearchByNameFragment())
            )
        TabLayoutMediator(binding.tbPages, binding.vpTabs) { tab, pos ->
            tab.text = tabPages[pos]
        }.attach()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun applySystemInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(requireView()) { _, windowInsets ->
            val statusBarInset = windowInsets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            val navBarInset = windowInsets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom
            val imeInset = windowInsets.getInsets(WindowInsetsCompat.Type.ime()).bottom
            val bottomInset = max(imeInset, navBarInset)
            binding.root.updatePadding(top = statusBarInset, bottom = bottomInset)
            windowInsets
        }
    }
}