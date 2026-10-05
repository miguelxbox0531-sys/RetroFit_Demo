package com.example.retrofit_demo.network

import com.example.retrofit_demo.model.Post
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<Post>
}