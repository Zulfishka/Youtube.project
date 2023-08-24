package com.example.youtubeproject.ui.details

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.youtubeproject.core.Status
import com.example.youtubeproject.core.base.BaseActivity
import com.example.youtubeproject.data.model.Playlist
import com.example.youtubeproject.databinding.ActivityDetailBinding
import com.example.youtubeproject.ui.details.adapter.DetailAdapter
import com.example.youtubeproject.ui.video.PlayVideoActivity
import com.example.youtubeproject.utils.ConnectionLiveData
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>() {

    private val modelPlaylist by lazy { intent.extras?.getSerializable("key") as Playlist.Item }
    private val adapter by lazy { DetailAdapter(this::onClick) }

    override val viewModel: DetailViewModel by viewModel()

    private fun onClick(item: Playlist.Item) {
        val intent = Intent(this, PlayVideoActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable("jj", item)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    override fun setupLiveData() {
        super.setupLiveData()
        viewModel.getPlaylistItem(modelPlaylist.id).observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    adapter.addList(it.data?.items as MutableList<Playlist.Item>)
                    binding.tvDescription.text = modelPlaylist.snippet.description
                    binding.tvTitle.text = modelPlaylist.snippet.title
                    binding.progressBar.isVisible = false
                    binding.tvVideoCount.text = "${modelPlaylist.contentDetails.itemCount} video"
                }

                Status.ERROR -> {
                    binding.progressBar.isVisible = false
                }

                Status.LOADING -> {
                    binding.progressBar.isVisible = true
                }
            }
        }
    }

    override fun initClick() {
        super.initClick()
        binding.tvBack.setOnClickListener {
            finish()
        }
        binding.recyclerView.adapter = adapter
    }

    override fun inflateViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun checkInternet() {
        super.checkInternet()
        ConnectionLiveData(application).observe(this) {
            if (it) {
                binding.internetConnection.visibility = View.VISIBLE
                binding.noConnection.visibility = View.GONE

            } else {
                binding.internetConnection.visibility = View.GONE
                binding.noConnection.visibility = View.VISIBLE
            }
        }


    }
    companion object
        {
            const val PLAYLIST_ITEM_KEY = "playlistItem"
        }

}