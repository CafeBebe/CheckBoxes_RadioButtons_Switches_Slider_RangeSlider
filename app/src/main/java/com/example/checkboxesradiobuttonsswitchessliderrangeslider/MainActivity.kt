package com.example.checkboxesradiobuttonsswitchessliderrangeslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.checkboxesradiobuttonsswitchessliderrangeslider.databinding.ActivityMainBinding
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)



        binding?.containedIconButton?.setOnClickListener(View.OnClickListener {

            supportFragmentManager.beginTransaction().replace(R.id.content,Play()).commit()})





        binding?.slider?.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                binding?.selectedPart?.text = getString(R.string.action)
            }


            override fun onStopTrackingTouch(slider: Slider) {
                binding?.selectedPart?.text = getString(R.string.beforeAction)
            }
        })

        binding?.slider?.addOnChangeListener { slider, value, fromUser ->
            binding?.descSelectedPart?.text = getString(R.string.yourSelected) + " " + value + " " +
                    getString(R.string.series)

            binding?.selectedPart?.visibility = View.VISIBLE

            binding?.containedIconButton?.isEnabled = true
        }

    }

}