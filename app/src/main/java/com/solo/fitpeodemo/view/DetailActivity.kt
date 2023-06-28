package com.solo.fitpeodemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.solo.fitpeodemo.R
import com.solo.fitpeodemo.databinding.ActivityDetailBinding
import com.solo.fitpeodemo.network.model.PhotosModel

class DetailActivity : AppCompatActivity() {

    lateinit var binding : ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_detail)
       val model = intent.extras?.get("model") as PhotosModel
        binding.model = model
    }

}