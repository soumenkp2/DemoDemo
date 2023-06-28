package com.example.demodemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demodemo.api.*
import com.example.demodemo.repository.QuotesRepository
import com.example.demodemo.viewmodels.QuotesViewModel
import com.example.demodemo.viewmodels.QuotesViewModelFactory
import retrofit2.create

import android.arch.lifecycle.ViewModelProvider
import android.util.Log

private lateinit var quotesViewModel: QuotesViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val QuoteService = SingeltonRetorfit.getInstance().create(QuoteService::class.java)
        val repository = QuotesRepository(QuoteService)

        quotesViewModel = ViewModelProvider(this,QuotesViewModelFactory(repository)).get(QuotesViewModel::class.java)

        quotesViewModel.quotesLiveData.observe(this,
            {
                Log.d("data",it.results.toString())
            })
    }
}