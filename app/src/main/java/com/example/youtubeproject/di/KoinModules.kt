package com.example.youtubeproject.di

import com.example.youtubeproject.core.network.remoteModule
import com.example.youtubeproject.data.remote.remoteDataSource
import org.koin.core.module.Module


val koinModules = listOf<Module>(
    repoModules, viewModules,remoteModule,remoteDataSource
)