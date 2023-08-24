package com.example.youtubeproject.ui.playlist.viewModel

import androidx.lifecycle.LiveData
import com.example.youtubeproject.App
import com.example.youtubeproject.core.Resource
import com.example.youtubeproject.core.base.BaseViewModel
import com.example.youtubeproject.data.model.Playlist
import com.example.youtubeproject.repository.Repository

class PlaylistsViewModel(private val repository: Repository): BaseViewModel() {

    fun getPlaylist():LiveData<Resource<Playlist>>{
        return repository.getPlaylists()
    }

}