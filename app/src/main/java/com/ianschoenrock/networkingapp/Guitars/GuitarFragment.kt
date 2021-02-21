package com.ianschoenrock.networkingapp.Guitars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ianschoenrock.networkingapp.Posts.PostAdapter
import com.ianschoenrock.networkingapp.Posts.PostViewModel
import com.ianschoenrock.networkingapp.R


class GuitarFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_guitar, container, false).apply{
            val guitarRV = findViewById<RecyclerView>(R.id.guitar_rv)

            val guitarViewModel = ViewModelProvider(this@GuitarFragment).get(
                GuitarViewModel::class.java
            )

            guitarViewModel.guitarResponse.observe(viewLifecycleOwner, Observer { guitarResponse ->
                println(guitarResponse)
                val guitarAdapter = GuitarAdapter(guitarResponse.guitars)
                guitarRV.adapter = guitarAdapter
                guitarRV.layoutManager = LinearLayoutManager(requireContext())
            })
            guitarViewModel.getGuitars()
        }
    }

}