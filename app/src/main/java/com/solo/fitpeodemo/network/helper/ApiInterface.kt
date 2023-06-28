package com.solo.fitpeodemo.network.helper

import com.solo.fitpeodemo.network.model.PhotosModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("photos")
    suspend fun getPhoto() : Response<List<PhotosModel>>

}