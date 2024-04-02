package com.example.ntiteam_test_work_foodies.api

import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {
    @GET("Categories.json")
    suspend fun getCategories(): List<Category>

    @GET("Tags.json")
    suspend fun getTags(): List<Tag>

    @GET("Products.json")
    suspend fun getProducts(): List<Product>

    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id: String): Product
}
