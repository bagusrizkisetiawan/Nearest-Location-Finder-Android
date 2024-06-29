package com.bagusrizki.ainun.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bagusrizki.ainun.LocationAdapter
import com.bagusrizki.ainun.LocationProvider
import com.bagusrizki.ainun.R
import com.bagusrizki.ainun.databinding.ActivityMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)


        binding.menuUnitDonorDarah.setOnClickListener(){
            val intent = Intent(this, UnitDonorDarahActivity::class.java)
            startActivity(intent)
        }

        binding.menuLokasiDonor.setOnClickListener(){
            val intent = Intent(this, LokasiDonorDarahActivity::class.java)
            startActivity(intent)
        }

        binding.menuArtikel.setOnClickListener(){
            val intent = Intent(this, ArtikelActivity::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}
