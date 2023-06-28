package com.solo.fitpeodemo.network.helper

import com.solo.fitpeodemo.network.model.PhotosModel
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(val apiInterface: ApiInterface) : ApiHelper {

    override suspend fun getPhotos():  Response<List<PhotosModel>> {
       return  apiInterface.getPhoto()
    }
}