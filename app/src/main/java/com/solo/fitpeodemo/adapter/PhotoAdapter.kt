package com.solo.fitpeodemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.solo.fitpeodemo.network.model.PhotosModel
import com.solo.fitpeodemo.R
import com.solo.fitpeodemo.databinding.ItemListPhotosBinding
import com.squareup.picasso.Picasso

class PhotoAdapter(val list : MutableList<PhotosModel>, val onClick: (PhotosModel)-> Unit) : RecyclerView.Adapter<PhotoAdapter.PhotoHolder>()  {

    class PhotoHolder(val binding: ItemListPhotosBinding) :RecyclerView.ViewHolder( binding.root){
        fun bind(photosModel: PhotosModel){
            binding.model = photosModel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAdapter.PhotoHolder {
       val binding = ItemListPhotosBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       return PhotoHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoAdapter.PhotoHolder, position: Int) {
        with(holder){
            with(list[position]){
                holder.bind(this)
                binding.layout.setOnClickListener { onClick(this) }
            }
        }
    }

    override fun getItemCount(): Int = list.size

}