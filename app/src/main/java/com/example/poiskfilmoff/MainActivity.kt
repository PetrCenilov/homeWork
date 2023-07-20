package com.example.poiskfilmoff

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide.init
import com.example.poiskfilmoff.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),FilmListRecyclerAdapter.Listener {

    //private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private val filmsDataBase = listOf(
        Film(
            "His Only Son",
            R.drawable.his_only_son,
            "After being called on by the Lord, Abraham's faith is tested on his three day journey to sacrifice his son."
        )
    )
    lateinit var binding: ActivityMainBinding
    private var filmsAdapter = FilmListRecyclerAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigation()

    }

    private fun initNavigation() {
        binding.apply {
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.Listener {

                override fun onClick(film: Film) {
                  val bundle = Bundle()
                  bundle.putParcelable("Film",film)
                   val intent = Intent (this@MainActivity,DetailsActivity::class.java)
                  intent.putExtras(bundle)
                 startActivity(intent)
                  }

            })
            mainRecycler.layoutManager = LinearLayoutManager(this@MainActivity)
            mainRecycler.adapter = filmsAdapter
        }
        filmsAdapter.addItems(filmsDataBase)


        binding.topAppBar.setOnMenuItemClickListener() {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }

        binding.bottomNavigation.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.favorites -> {
                    Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.watch_later -> {
                    Toast.makeText(this, "Посмотреть позже", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.selections -> {
                    Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }
    }

    override fun onClick(film: Film) {
        val bundle = Bundle()
        bundle.putParcelable("Film",film)
        val intent = Intent (this@MainActivity,DetailsActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }


}

