package com.cuellar.examplemvvm

import com.cuellar.examplemvvm.R

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.cuellar.examplemvvm.databinding.ActivityMainBinding
import com.cuellar.examplemvvm.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

            quoteViewModel.quoteModel.observe(this, Observer { currentQuote->
                binding.tvQuote.text = currentQuote.quote
                binding.tvAuthor.text = currentQuote.author
            })
            binding.viewContainer.setOnClickListener{quoteViewModel.randomQuote()}
        }
    }
