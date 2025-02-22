package com.example.ntiteam_test_work_foodies.api

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val apiService = RetrofitClient.instance.create(ProductService::class.java)
    val categories: LiveData<List<Category>> = MutableLiveData()
    val tags: LiveData<List<Tag>> = MutableLiveData()
    val products: LiveData<List<Product>> = MutableLiveData()

    fun fetchData() {
        viewModelScope.launch {
            try {
                (categories as MutableLiveData).value = apiService.getCategories()
                (tags as MutableLiveData).value = apiService.getTags()
                (products as MutableLiveData).value = apiService.getProducts()
            } catch (e: Exception) {
                // Обработка ошибок
                Log.e("MainViewModel", "Ошибка при получении данных с сервера", e)
            }
        }
    }

    @SuppressLint("NullSafeMutableLiveData")
    fun getProductById(id: String): LiveData<Product> {
        val productLiveData = MutableLiveData<Product>()
        viewModelScope.launch {
            try {
                val product = apiService.getProductById(id)
                productLiveData.value = product
            } catch (e: Exception) {
                Log.e("MainViewModel", "Ошибка при получении информации о продукте", e)
                productLiveData.value = null
            }
        }
        return productLiveData
    }
}