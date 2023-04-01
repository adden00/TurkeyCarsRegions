package com.example.turkeyregions.app.presentation.search_by_code_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.turkeyregions.app.presentation.RegionViewModel
import com.example.turkeyregions.databinding.FragmemtSearchByCodeBinding

class SearchByCodeFragment : Fragment() {
    private lateinit var binding: FragmemtSearchByCodeBinding
    private val viewModel: RegionViewModel by activityViewModels()
    private val buttonsAdapter: ButtonAdapter by lazy { ButtonAdapter(ButtonListener()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmemtSearchByCodeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButtons()
        observeRegionName()
        updateData()
    }

    private fun updateData() {
        viewModel.updateRegions(requireContext())
    }

    private fun observeRegionName() {
        viewModel.currentRegion.observe(viewLifecycleOwner) {
            binding.tvRegionName.text = it ?: "Введите код региона"
        }
        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        }
    }

    private fun setButtons() {
        binding.edRegionNumber.requestFocus() // ставим курсор
        requireActivity().window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE) // открываем клаву
        binding.edRegionNumber.addTextChangedListener { text ->
            viewModel.searchCode(text?.toString()!!)
        }

        binding.rcButtons.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.rcButtons.adapter = buttonsAdapter


        val buttonsList = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "C", "0", "🔍")
        buttonsAdapter.submitList(buttonsList)


    }

    private inner class ButtonListener : ButtonAdapter.Listener {
        override fun onClick(item: String) {
            when (item) {
                "C" -> binding.edRegionNumber.setText("")
                "🔍" -> binding.edRegionNumber.setText("")
                else -> binding.edRegionNumber.setText(binding.edRegionNumber.text.toString() + item)
            }


        }
    }

}