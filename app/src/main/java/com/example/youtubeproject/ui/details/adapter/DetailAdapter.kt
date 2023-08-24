package com.example.youtubeproject.ui.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeproject.data.model.Playlist
import com.example.youtubeproject.databinding.ItemDetailBinding
import com.example.youtubeproject.utils.load

class DetailAdapter(private val onClick: (Playlist.Item) -> Unit) :
    RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {

    private var list = mutableListOf<Playlist.Item>()

    fun addList(list: List<Playlist.Item>) {
        this.list = list as MutableList<Playlist.Item>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(
            ItemDetailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class DetailViewHolder(private val binding: ItemDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Playlist.Item) {
            binding.tvTime.text = item.kind ?: "Пусто"
            binding.tvVideoName.text = item.snippet.title ?: "Пусто"
            binding.ivVideo.load(item.snippet.thumbnails.standard.url!!) ?: "Пусто"
            itemView.setOnClickListener {
                onClick(item)
            }
        }
    }
}