package com.example.demodemo.repository

import android.text.style.QuoteSpan
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.demodemo.api.QuoteService
import com.example.demodemo.models.QuoteList

class QuotesRepository(val ServiceInstance : QuoteService) {
    private lateinit var quotesData: QuoteList

    suspend fun getQuotesData(page: Int) {
        val result = ServiceInstance.getQuotes(page)
        quotesData = result.body()!!
    }

    public fun getQuotesList() : QuoteList
    {
        return quotesData
    }

}