package com.bagusrizki.ainun.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bagusrizki.ainun.ArtikelAdapter
import com.bagusrizki.ainun.ArtikelProvider
import com.bagusrizki.ainun.R
import com.bagusrizki.ainun.databinding.ActivityArtikelBinding

class ArtikelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtikelBinding
    private lateinit var adapter: ArtikelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtikelBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        // Set up toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        adapter = ArtikelAdapter(ArtikelProvider.artikel)
        binding.rvArtikel.layoutManager = LinearLayoutManager(this)
        binding.rvArtikel.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
