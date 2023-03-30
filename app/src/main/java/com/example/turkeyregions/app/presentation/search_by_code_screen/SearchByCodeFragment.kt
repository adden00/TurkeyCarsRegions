package com.example.turkeyregions.app.presentation.search_by_code_screen

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.turkeyregions.app.presentation.RegionViewModel
import com.example.turkeyregions.databinding.FragmemtSearchByCodeBinding

class SearchByCodeFragment : Fragment() {
    private lateinit var binding: FragmemtSearchByCodeBinding
    private val viewModel: RegionViewModel by activityViewModels()

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
    }

    private fun observeRegionName() {
        viewModel.currentRegion.observe(viewLifecycleOwner) {
            binding.tvRegionName.text = it ?: "Введите код региона"
        }
    }

    private fun setButtons() {
        binding.edRegionNumber.requestFocus() // ставим курсор
        requireActivity().window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE) // открываем клаву
        binding.edRegionNumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(text: Editable?) {
                viewModel.searchCode(text?.toString()!!)
            }

        })

        binding.btnClear.setOnClickListener {
            binding.edRegionNumber.setText("")
        }
    }

}