package com.example.youtubeproject.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(text:String){
    Glide.with(this).load(text).into(this)
}

fun Int.toMinus(int: Int){
    this - 5
}