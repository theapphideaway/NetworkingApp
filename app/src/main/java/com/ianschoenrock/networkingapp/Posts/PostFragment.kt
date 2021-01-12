package com.ianschoenrock.networkingapp.Posts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.ianschoenrock.networkingapp.R
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PostFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post, container, false).apply{
            val postRV = findViewById<RecyclerView>(R.id.post_rv)

            val postViewModel = ViewModelProvider(this@PostFragment).get(
                PostViewModel::class.java
            )

            postViewModel.posts.observe(viewLifecycleOwner, Observer { posts ->
                println(posts)
                val postAdapter = PostAdapter(posts)
                postRV.adapter = postAdapter
                postRV.layoutManager = LinearLayoutManager(requireContext())
            })
            postViewModel.getPosts()
        }
    }

}