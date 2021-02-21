package com.ianschoenrock.networkingapp.Guitars

import Models.Guitar
import Models.PostElement
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ianschoenrock.networkingapp.Posts.PostViewHolder
import com.ianschoenrock.networkingapp.R

class GuitarAdapter(private val guitars: List<Guitar>): RecyclerView.Adapter<GuitarViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuitarViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.guitar_item, parent, false)
        return GuitarViewHolder(inflater)
    }

    override fun getItemCount(): Int = guitars.count()

    override fun onBindViewHolder(holder: GuitarViewHolder, position: Int) {
        holder.setData(guitars[position].g_name, guitars[position].g_image)
    }
}