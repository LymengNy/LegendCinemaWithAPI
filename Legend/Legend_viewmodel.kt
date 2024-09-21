package com.example.yujie.Legend

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LegendViewModel : ViewModel() {
    private val _resultList = mutableStateListOf<MovieResults>()
    var errorMessage: String by mutableStateOf("")
    var isLoading: Boolean by mutableStateOf(false)
    val resultList: List<MovieResults>
        get() = _resultList

    // Function to fetch movie details
    fun getResultList(page: Int = 1) {
        viewModelScope.launch {
            isLoading = true
            val service = LegendService.getInstance()
            try {
                _resultList.clear()
                _resultList.addAll(service.getMovies(page = page).results)
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            } finally {
                isLoading = false
            }
        }
    }

    // Function to fetch video URL for a movie
    fun fetchVideoUrl(movieId: Int): String {
        // Replace with actual API call to get the video URL
        // For example, using the TMDb API, you would use a different endpoint
        // to get the video details
        val videoUrl = "https://path/to/video.mp4" // Replace this with actual URL retrieval logic
        return videoUrl
    }
}
