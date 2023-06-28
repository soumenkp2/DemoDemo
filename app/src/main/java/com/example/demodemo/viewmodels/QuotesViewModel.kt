package com.example.demodemo.viewmodels

import androidx.annotation.RestrictTo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demodemo.models.QuoteList
import com.example.demodemo.repository.QuotesRepository
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class QuotesViewModel(private val quotesRepository: QuotesRepository) : ViewModel() {

    public lateinit var quotesLiveData : MutableLiveData<QuoteList>


    init
    {
        viewModelScope.launch {
            quotesRepository.getQuotesData(1)
        }

        quotesLiveData.setValue(getQuotesData())

    }

    fun getQuotesData() : QuoteList
    {
        return quotesRepository.getQuotesList()
    }

}