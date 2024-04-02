package com.example.ntiteam_test_work_foodies.api

import retrofit2.http.GET

interface ProductService {
    @GET("Categories.json")
    suspend fun getCategories(): List<Category>

    @GET("Tags.json")
    suspend fun getTags(): List<Tag>

    @GET("Products.json")
    suspend fun getProducts(): List<Product>
}
