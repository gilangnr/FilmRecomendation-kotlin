package com.example.submissiondicoding

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvFilms: RecyclerView
    private val list = ArrayList<Film>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFilms = findViewById(R.id.rv_films)
        rvFilms.setHasFixedSize(true)

        list.addAll(getListFilms())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_page -> {
                startActivity(Intent(this, AboutActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getListFilms(): ArrayList<Film> {
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataRate = resources.getStringArray(R.array.data_rate)
        val dataPoster = resources.obtainTypedArray(R.array.data_poster)
        val dataSinopsis = resources.getStringArray(R.array.data_sinopsis)
        val listFilm = ArrayList<Film>()
        for (i in dataTitle.indices) {
            val film = Film(dataTitle[i], dataRate[i], dataPoster.getResourceId(i, -1), dataSinopsis[i])
            listFilm.add(film)
        }
        return listFilm
    }

    private fun showRecyclerList() {
        rvFilms.layoutManager = LinearLayoutManager(this)
        val listFilmAdapter = ListFilmAdapter(list)
        rvFilms.adapter = listFilmAdapter
    }
}