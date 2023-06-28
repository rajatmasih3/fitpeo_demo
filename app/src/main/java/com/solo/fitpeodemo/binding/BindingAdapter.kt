package com.solo.fitpeodemo.binding

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.solo.fitpeodemo.R
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl","error")
fun loadImage(view : ImageView, imageUrl :String, error:Drawable){
    Picasso.get().load(imageUrl).placeholder(R.drawable.progress).error(error).into(view)
}