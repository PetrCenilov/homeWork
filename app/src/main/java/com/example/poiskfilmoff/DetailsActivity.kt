package com.example.poiskfilmoff

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.poiskfilmoff.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var film: Film
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val film = intent.getSerializableExtra("film") as Film
        val arguments: Nothing? = null
        film = arguments?.get("Film") as Film
        binding.apply {
            detailsToolbar.title = film.title
            detailsPoster.setImageResource(film.poster)
            detailsDescription.text = film.description

        }

    }
}