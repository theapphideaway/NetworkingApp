package com.ianschoenrock.networkingapp.Posts

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ianschoenrock.networkingapp.R

class PostViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    fun setData(title: String){
        val titleTV = view.findViewById<TextView>(R.id.title_tv)
        titleTV.text = title
    }
}