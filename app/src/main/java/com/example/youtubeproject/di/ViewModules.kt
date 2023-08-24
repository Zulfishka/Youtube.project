package com.example.youtubeproject.di

import com.example.youtubeproject.ui.details.DetailViewModel
import com.example.youtubeproject.ui.playlist.viewModel.PlaylistsViewModel
import com.example.youtubeproject.ui.video.PlayVideoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModules = module {
    viewModel { DetailViewModel(get()) }
    viewModel { PlaylistsViewModel(get()) }
    viewModel { PlayVideoViewModel(get()) }
}