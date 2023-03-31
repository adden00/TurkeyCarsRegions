package com.example.turkeyregions.app.presentation.search_by_name_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.turkeyregions.app.presentation.RegionViewModel
import com.example.turkeyregions.databinding.FragmemtSearchByNameBinding

class SearchByNameFragment : Fragment() {
    private var _binding: FragmemtSearchByNameBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RegionViewModel by activityViewModels()
    private val regionsAdapter: RegionAdapter by lazy { RegionAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmemtSearchByNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.searchRegion("")
        setUpUI()
        observeRegionName()

    }

    override fun onResume() {
        super.onResume()


    }

    private fun observeRegionName() {
        viewModel.currentNumbers.observe(viewLifecycleOwner) {
            regionsAdapter.submitList(it)

        }
    }

    private fun setUpUI() {

        binding.rcRegions.adapter = regionsAdapter

        binding.edRegionName.addTextChangedListener { text ->
            viewModel.searchRegion(text?.toString() ?: "")
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}