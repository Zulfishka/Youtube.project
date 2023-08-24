package com.example.youtubeproject.ui.details

import androidx.lifecycle.LiveData
import com.example.youtubeproject.core.Resource
import com.example.youtubeproject.core.base.BaseViewModel
import com.example.youtubeproject.data.model.Playlist
import com.example.youtubeproject.repository.Repository

class DetailViewModel(private val repository: Repository) : BaseViewModel() {

    fun getPlaylistItem(playlistId: String): LiveData<Resource<Playlist>> {
        return repository.getPlaylistItem(playlistId)
    }

}