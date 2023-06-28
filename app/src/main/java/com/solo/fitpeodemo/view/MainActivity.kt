package com.solo.fitpeodemo.view

import CheckNetworkConnection
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.solo.fitpeodemo.network.model.PhotosModel
import com.solo.fitpeodemo.R
import com.solo.fitpeodemo.adapter.PhotoAdapter
import com.solo.fitpeodemo.databinding.ActivityMainBinding
import com.solo.fitpeodemo.utils.Status
import com.solo.fitpeodemo.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
     var list = mutableListOf<PhotosModel>()
    lateinit var adapter: PhotoAdapter
     private val viewModel : MainViewModel  by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        if (Build.VERSION.SDK_INT > 9) {
            val policy = ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }
        if (CheckNetworkConnection.isNetworkAvailable(this)){
            viewModel.getPhotos()
        }else{
            Toast.makeText(this, "No Internet", Toast.LENGTH_SHORT).show()
        }


        viewModel.livedata.observe(this){
           when(it.status){
               Status.SUCCESS ->{
                   it.data?.forEach {
                       list.add(it)
                   }
                   addToList()
                binding.progress.visibility = View.GONE
               }Status.LOADING ->{
               binding.progress.visibility = View.VISIBLE
               }Status.ERROR ->{
               binding.progress.visibility = View.GONE
               Toast.makeText(this, "Something went wrong.", Toast.LENGTH_SHORT).show()
               }
           }
        }

    }
    fun addToList(){

            adapter = PhotoAdapter(list){

                val intent  = Intent(this,DetailActivity::class.java)
                intent.putExtra("model",it)
                startActivity(intent)
            }

            binding.recycler.setHasFixedSize(true)
            binding.recycler.layoutManager = LinearLayoutManager(this)
           binding.recycler.adapter = adapter
        }

}