package com.example.youtubeproject.ui.playlist.viewModel

import androidx.lifecycle.LiveData
import com.example.youtubeproject.App
import com.example.youtubeproject.core.base.BaseViewModel
import com.example.youtubeproject.data.model.Playlist
import com.example.youtubeproject.repository.Repository

class PlaylistsViewModel: BaseViewModel() {

    fun getPlaylist():LiveData<Playlist>{
        return App.repository.getPlaylist()
    }

}