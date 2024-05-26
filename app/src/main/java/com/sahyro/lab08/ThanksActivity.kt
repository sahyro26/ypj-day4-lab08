package com.sahyro.lab08

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sahyro.lab08.databinding.ActivityMainBinding
import com.sahyro.lab08.databinding.ActivityThanksBinding

class ThanksActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThanksBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThanksBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.nameTextView.text = intent.getStringExtra("name")
        binding.phoneNoTextView.text = intent.getStringExtra("phone")
        binding.pizzaSizeTextView.text = intent.getStringExtra("pizzaSize")
        binding.pickupDateTextView.text = intent.getStringExtra("pickupDate")
        binding.pickupTImeTextView.text = intent.getStringExtra("pickupTime")

        binding.ratingButton.setOnClickListener {
            binding.ratingTextView.text = binding.ratingBar.rating.toString()
        }


    }
}