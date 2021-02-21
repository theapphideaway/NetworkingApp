package com.ianschoenrock.networkingapp.Guitars

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ianschoenrock.networkingapp.R
import com.squareup.picasso.Picasso

class GuitarViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    fun setData(title: String, image: String){
        val titleTV = view.findViewById<TextView>(R.id.guitar_title_tv)
        val imageIV = view.findViewById<ImageView>(R.id.guitar_image_iv)
        titleTV.text = title
        Picasso.get().load(image).into(imageIV)
    }
}