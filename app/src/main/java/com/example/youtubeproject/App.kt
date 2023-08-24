package com.example.youtubeproject

import android.app.Application
import com.example.youtubeproject.di.koinModules
import com.example.youtubeproject.repository.Repository
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            //даем ему контекст и говорим что он будет
            // (что бы коин мог проинициализироватся и он будет здесь инициалищироватся )
            androidContext(this@App)
            modules(koinModules)
        }
    }
}