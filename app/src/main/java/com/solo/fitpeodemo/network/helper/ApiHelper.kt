package com.solo.fitpeodemo.network.helper

import com.solo.fitpeodemo.network.model.PhotosModel
import retrofit2.Response

interface ApiHelper {
   suspend fun getPhotos() : Response<List<PhotosModel>>
}