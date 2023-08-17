package com.example.youtubeproject.data.remote

import com.example.youtubeproject.data.model.Playlist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("playlists")
    fun getPlaylist(
        @Query("key") keyApi:String,
        @Query("part") partKey:String,
        @Query("channelId") channelId:String,
        @Query("maxResults") maxResults:Int =5
    ):Call<Playlist>
}