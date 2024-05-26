package com.sahyro.lab08

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sahyro.lab08.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val pizzaSizes = arrayOf("Please Select Size", "Small", "Medium", "Large", "Extra Large")

        binding.pizzaSizeSeekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.pizzaSizeTextView.text = pizzaSizes[progress]
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                binding.pizzaSizeTextView.text = "Seekbar mula ditekan"
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        binding.selectDatebutton.setOnClickListener {
            val c = Calendar.getInstance()
            val day = c.get(Calendar.DAY_OF_MONTH)
            val month = c.get(Calendar.MONTH)
            val year = c.get(Calendar.YEAR)

            val myDatePicker =
                DatePickerDialog(this,
                    android.R.style.ThemeOverlay,
                    DatePickerDialog.OnDateSetListener {view, year, month, dayOfMonth ->
                        binding.dateTextView.text = "$dayOfMonth/${month+1}/$year"
                    },
                    year,
                    month,
                    day
                    )
            myDatePicker.show()
        }

        binding.selectTimeButton.setOnClickListener {
            val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minutes = c.get(Calendar.MINUTE)

            val myTImePicker = TimePickerDialog(this,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
//                    val hourFormatted = String.format("%2f", hourOfDay)
//                    val minuteFormatted = String.format("%2f", minute)
                    binding.timeTextView.text = "$hourOfDay:$minute"
                },
                hour,
                minutes,
                true
            )
            myTImePicker.show()
        }


        binding.scheduleButton.setOnClickListener {
            var intent = Intent(this, ThanksActivity:: class.java)
            intent.putExtra("name",binding.nameEditTextText.text.toString())
            intent.putExtra("phone",binding.phoneNoEditTextText.text.toString())
            intent.putExtra("pizzaSize",binding.pizzaSizeTextView.text.toString())
            intent.putExtra("pickupDate",binding.dateTextView.text.toString())
            intent.putExtra("pickupTime",binding.timeTextView.text.toString())

            startActivity(intent)
        }
    }
}