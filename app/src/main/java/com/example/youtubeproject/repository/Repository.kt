package com.example.youtubeproject.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeproject.BuildConfig
import com.example.youtubeproject.core.network.RetrofitClient
import com.example.youtubeproject.data.model.Playlist
import com.example.youtubeproject.data.remote.ApiService
import com.example.youtubeproject.utils.Constants.CHANNEL_ID
import com.example.youtubeproject.utils.Constants.PART
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private val apiService: ApiService by lazy { RetrofitClient.create() }

    fun getPlaylist(): LiveData<Playlist> {

        val data = MutableLiveData<Playlist>()
        apiService.getPlaylist(BuildConfig.API_KEY, PART, CHANNEL_ID).enqueue(
            object : Callback<Playlist> {
                override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<Playlist>, t: Throwable) {
                    Log.e("OLOLO", "onFailure: ${t.message}")
                }

            }
        )
        return data
    }
}