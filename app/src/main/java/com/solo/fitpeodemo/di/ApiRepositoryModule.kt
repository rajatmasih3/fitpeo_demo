package com.solo.fitpeodemo.di

import com.solo.fitpeodemo.network.helper.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiRepositoryModule {

   /* fun providerPhotoRepository() : NetworkRepository{
           return NetworkRepository(ApiInterface.create())
    }*/


    @Provides
    fun provideBaseUrl() :String = "https://jsonplaceholder.typicode.com/"


    @Singleton
    @Provides
    fun provideRetrofit(base_url:String) :Retrofit = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    fun provideApiInterface(retrofit: Retrofit) : ApiInterface = retrofit.create<ApiInterface>()

}