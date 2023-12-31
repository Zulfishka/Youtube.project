package com.example.youtubeproject.ui.playlist.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.youtubeproject.data.model.Playlist
import com.example.youtubeproject.databinding.ItemPlaylistBinding

class PlaylistAdapter : RecyclerView.Adapter<PlaylistAdapter.PlayListViewHolder>() {

    var list = mutableListOf<Playlist.Item>()

    @SuppressLint("NotifyDataSetChanged")
    fun addData(lists: List<Playlist.Item>) {
        this.list = lists as MutableList<Playlist.Item>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlayListViewHolder {
        return PlayListViewHolder(
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlayListViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int =
        list.size


    inner class PlayListViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(item: Playlist.Item) {
            binding.ivPlaylistImage.load(item.snippet.thumbnails.default.url)
            binding.namePlaylist.text = item.snippet.title
            binding.tvAmountVideo.text = item.contentDetails.itemCount.toString() + " video series"
        }
    }
}