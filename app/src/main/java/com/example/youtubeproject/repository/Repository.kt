package com.example.youtubeproject.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.youtubeproject.core.Resource
import com.example.youtubeproject.data.model.Playlist
import com.example.youtubeproject.data.remote.ApiService
import com.example.youtubeproject.data.remote.RemoteDataSource
import kotlinx.coroutines.Dispatchers

class Repository(private val apiService: ApiService, private val dataSource: RemoteDataSource) {

    fun getPlaylists(): LiveData<Resource<Playlist>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val response = dataSource.getPlaylist()
            emit(response)
        }
    }


    fun getPlaylistItem(playlistItem: String): LiveData<Resource<Playlist>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val response = dataSource.getPlaylistItem(playlistItem)
            emit(response)
        }
    }

    fun getVideo(id: String): LiveData<Resource<Playlist>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val response = dataSource.getVideo(id)
            emit(response)
        }
    }

}