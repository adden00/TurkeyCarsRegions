package com.example.turkeyregions.app.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import com.example.turkeyregions.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: RegionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setButtons()
        observeRegionName()


    }

    private fun observeRegionName() {
        viewModel.currentRegion.observe(this) {
            binding.tvRegionName.text = if (it == null) "Введите код региона" else it
        }
    }

    private fun setButtons() {
        binding.edRegionNumber.requestFocus() // ставим курсор
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE) // открываем клаву
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

