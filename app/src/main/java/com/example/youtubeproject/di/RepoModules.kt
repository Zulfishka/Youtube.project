package com.example.youtubeproject.di

import com.example.youtubeproject.repository.Repository
import org.koin.dsl.module

val repoModules = module {
    single { Repository(get(),get()) }
}