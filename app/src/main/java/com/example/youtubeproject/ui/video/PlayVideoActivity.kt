package com.example.youtubeproject.ui.video

import androidx.core.view.isVisible
import com.example.youtubeproject.core.base.BaseActivity
import com.example.youtubeproject.data.model.Playlist
import com.example.youtubeproject.databinding.ActivityPlayVideoBinding
import com.example.youtubeproject.ui.details.DetailActivity.Companion.PLAYLIST_ITEM_KEY
import com.example.youtubeproject.ui.playlist.viewModel.PlaylistsViewModel
import com.example.youtubeproject.utils.ConnectionLiveData
import com.example.youtubeproject.utils.load
import org.koin.androidx.viewmodel.ext.android.viewModel


class PlayVideoActivity : BaseActivity<ActivityPlayVideoBinding,PlaylistsViewModel>() {

    private val modelVideo by lazy {
        intent.extras?.getSerializable("jj") as Playlist.Item
    }

    override fun inflateViewBinding(): ActivityPlayVideoBinding {
        return ActivityPlayVideoBinding.inflate(layoutInflater)
    }

    override val viewModel: PlaylistsViewModel  by viewModel()

    override fun initClick() {
        super.initClick()
        binding.tvTitle.text = modelVideo.snippet.title
        binding.tvDesc.text = modelVideo.snippet.description
        binding.youtubePlayerView.load(modelVideo.snippet.thumbnails.default.url)
        binding.tvBack.setOnClickListener{
            finish()
        }
    }

    override fun checkInternet() {
        super.checkInternet()
        ConnectionLiveData(application).observe(this) {
            if (it) {
                binding.noConnection.isVisible = false
                binding.internetConnection.isVisible = true
            } else {
                binding.noConnection.isVisible = true
                binding.internetConnection.isVisible = false
            }
        }
    }
}