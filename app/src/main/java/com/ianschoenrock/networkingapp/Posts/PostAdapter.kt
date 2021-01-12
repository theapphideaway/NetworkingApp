package com.ianschoenrock.networkingapp.Posts

import Models.PostElement
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ianschoenrock.networkingapp.R

class PostAdapter(private val posts: List<PostElement>): RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return PostViewHolder(inflater)
    }

    override fun getItemCount(): Int = posts.count()

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.setData(posts[position].title)
    }
}