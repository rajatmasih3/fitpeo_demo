package com.solo.fitpeodemo.network.repository

import com.solo.fitpeodemo.network.model.PhotosModel
import com.solo.fitpeodemo.network.helper.ApiHelperImpl
import retrofit2.Response
import javax.inject.Inject

class NetworkRepository @Inject constructor (private val apiHelperImpl: ApiHelperImpl) {
    suspend fun getPhotos() : Response<List<PhotosModel>> = apiHelperImpl.getPhotos()
}
