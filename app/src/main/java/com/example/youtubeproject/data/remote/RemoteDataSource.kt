package com.example.youtubeproject.data.remote

import com.example.youtubeproject.BuildConfig
import com.example.youtubeproject.core.Resource
import com.example.youtubeproject.core.base.BaseDataSource
import com.example.youtubeproject.data.model.Playlist
import org.koin.dsl.module

val remoteDataSource = module {
    factory { RemoteDataSource(get())}
}

class RemoteDataSource(private val apiService: ApiService) :BaseDataSource() {

    suspend fun getPlaylist(): Resource<Playlist> {
        return getResult {
            apiService.getPlaylists(
                BuildConfig.API_KEY, "snippet,contentDetails",
                "UCWOA1ZGywLbqmigxE4Qlvuw", 10
            )
        }
    }

    suspend fun getPlaylistItem(playlistItem: String): Resource<Playlist> {
        return getResult {
            apiService.getPlaylistItems(BuildConfig.API_KEY, part = "snippet,contentDetails",
                playlistId = playlistItem, maxResult = 10
            )
        }
    }

    suspend fun getVideo(id: String): Resource<Playlist> {
        return getResult {
            apiService.getVideo(apiKey = BuildConfig.API_KEY, part = "snippet,contentDetails", id)
        }
    }
}