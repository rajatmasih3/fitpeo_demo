package com.solo.fitpeodemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solo.fitpeodemo.network.model.PhotosModel
import com.solo.fitpeodemo.network.repository.NetworkRepository
import com.solo.fitpeodemo.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val networkRepository: NetworkRepository) :ViewModel()  {
   private val mutableLiveData = MutableLiveData<Resource<List<PhotosModel>>>();
   val livedata : LiveData<Resource<List<PhotosModel>>> get() = mutableLiveData

   fun getPhotos(){

       viewModelScope.launch {
          try {
              mutableLiveData.postValue(Resource.loading(null))
              networkRepository.getPhotos().let {
                  val res = it.body()
                  mutableLiveData.postValue(Resource.success(res))
              }
          }catch (e:java.lang.Exception){
              mutableLiveData.postValue(Resource.error("Some-thing went wrong",null))
          }
       }
   }

}