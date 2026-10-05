package com.example.retrofit_demo.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit_demo.model.Post
import com.example.retrofit_demo.network.RetrofitInstance
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {

    var posts by mutableStateOf<List<Post>>(emptyList())
        private set

    var isLoading by mutableStateOf(true)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    init {
        cargarPosts()
    }

    private fun cargarPosts() {
        viewModelScope.launch {
            try {
                posts = RetrofitInstance.api.getPosts()
            } catch (e: Exception) {
                errorMessage = "Error al cargar los datos: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }
}