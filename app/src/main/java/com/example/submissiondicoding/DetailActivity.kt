package com.example.submissiondicoding

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.findViewTreeViewModelStoreOwner

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_FILM = "extra_film"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24)
        }


        val txtTitle: TextView = findViewById(R.id.txt_title)
        val txtRate: TextView = findViewById(R.id.txt_rate)
        val txtDataSinopsis: TextView = findViewById(R.id.txt_data_sinopsis)
        val imgPoster: ImageView = findViewById(R.id.img_poster)
        val btnShare: Button = findViewById(R.id.btn_share)

        val film = intent.getParcelableExtra<Film>(EXTRA_FILM)

        film?.let {
            txtTitle.text = it.title
            txtRate.text = it.rate
            txtDataSinopsis.text = it.sinopsis
            imgPoster.setImageResource(it.poster)
        }

        btnShare.setOnClickListener {
            film?.let {
                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Check out this film: ${it.title}\nRating: ${it.rate}\n\nSinopsis:\n${it.sinopsis}")
                    type = "text/plain"
                }
                val chooser = Intent.createChooser(shareIntent, "Share this film via ")
                startActivity(chooser)
            }
        }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}