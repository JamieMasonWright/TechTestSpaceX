package com.javajj.lushTechTest.view.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.javajj.lushTechTest.R

@BindingAdapter("app:loadImage")
fun loadImage(imageView: ImageView, isSuccess: Boolean){
    if(isSuccess){
        Glide.with(imageView.context)
            .load(R.drawable.ic_success)
            .into(imageView)
    }
    else {
        Glide.with(imageView.context)
            .load(R.drawable.ic_fail)
            .into(imageView)
    }
}

@BindingAdapter("loadBadge")
fun loadBadge(imageView: ImageView, url: String?){
       Glide.with(imageView.context)
           .load(url)
           .into(imageView)
}