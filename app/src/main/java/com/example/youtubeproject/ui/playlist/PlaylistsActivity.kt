package com.example.youtubeproject.ui.playlist

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeproject.core.base.BaseActivity
import com.example.youtubeproject.data.model.Playlist
import com.example.youtubeproject.databinding.ActivityPlaylistsMainBinding
import com.example.youtubeproject.ui.playlist.adapter.PlaylistAdapter
import com.example.youtubeproject.ui.playlist.viewModel.PlaylistsViewModel

class PlaylistsActivity : BaseActivity<ActivityPlaylistsMainBinding, PlaylistsViewModel>() {

    private val adapter = PlaylistAdapter()

    override fun inflateViewBinding(): ActivityPlaylistsMainBinding =
        ActivityPlaylistsMainBinding.inflate(layoutInflater)

    override val viewModel: PlaylistsViewModel by lazy { ViewModelProvider(this)[PlaylistsViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.recyclerView.adapter = adapter
        viewModel.getPlaylist().observe(this) {
            adapter.addData(it.items as MutableList<Playlist.Item>)
        }
    }


}