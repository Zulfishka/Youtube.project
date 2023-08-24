package com.example.youtubeproject.ui.playlist

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeproject.core.Status
import com.example.youtubeproject.core.base.BaseActivity
import com.example.youtubeproject.data.model.Playlist
import com.example.youtubeproject.databinding.ActivityPlaylistsMainBinding
import com.example.youtubeproject.ui.details.DetailActivity
import com.example.youtubeproject.ui.playlist.adapter.PlaylistAdapter
import com.example.youtubeproject.ui.playlist.viewModel.PlaylistsViewModel
import com.example.youtubeproject.utils.ConnectionLiveData
import org.koin.androidx.viewmodel.ext.android.viewModel


class PlaylistsActivity : BaseActivity<ActivityPlaylistsMainBinding, PlaylistsViewModel>() {

    private val adapter = PlaylistAdapter(this::onClick)

    override fun inflateViewBinding(): ActivityPlaylistsMainBinding =
        ActivityPlaylistsMainBinding.inflate(layoutInflater)

    override val viewModel: PlaylistsViewModel by viewModel()

    private fun onClick(item:Playlist.Item){
        val intent = Intent(this,DetailActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable("key",item)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initClick()
        binding.recyclerView.adapter = adapter
        viewModel.getPlaylist().observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    adapter.addData(it.data?.items as MutableList<Playlist.Item>)
                 //   binding.progressBar.isVisible = false
                }

                Status.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                 //   binding.progressBar.isVisible = false
                }

                Status.LOADING -> {
                  //  binding.progressBar.isVisible = true
                }
            }
        }

    }

    override fun initClick() {
        super.initClick()
        ConnectionLiveData(application).observe(this) {
            if (it) {
                binding.noInternet.isVisible = false
                binding.internet.isVisible = true
            } else {
                binding.noInternet.isVisible = true
                binding.internet.isVisible = false
            }
        }
    }

}