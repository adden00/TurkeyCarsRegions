package com.addenisov00.turkeyregions.data.local

import android.content.Context

interface StringProvider {
    fun provideString(res: Int): String
}

class StringProviderImpl(private val context: Context): StringProvider {
    override fun provideString(res: Int): String {
        return context.getString(res)
    }
}