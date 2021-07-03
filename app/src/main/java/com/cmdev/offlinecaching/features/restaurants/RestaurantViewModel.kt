package com.cmdev.offlinecaching.features.restaurants

import androidx.lifecycle.*
import com.cmdev.offlinecaching.api.RestaurantApi
import com.cmdev.offlinecaching.data.Restaurant
import com.cmdev.offlinecaching.data.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    repository: RestaurantRepository
) : ViewModel() {

    val restaurants = repository.getRestaurants().asLiveData()
}