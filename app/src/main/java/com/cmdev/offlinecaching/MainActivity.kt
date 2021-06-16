package com.cmdev.offlinecaching

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmdev.offlinecaching.databinding.ActivityMainBinding
import com.cmdev.offlinecaching.features.restaurants.RestaurantAdapter
import com.cmdev.offlinecaching.features.restaurants.RestaurantViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: RestaurantViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val restaurantAdapter = RestaurantAdapter()

        binding.apply {
            recyclerView.apply {
                adapter = restaurantAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }

            viewModel.restaurants.observe(this@MainActivity) { restaurants ->
                restaurantAdapter.submitList(restaurants)
            }
        }
    }
}