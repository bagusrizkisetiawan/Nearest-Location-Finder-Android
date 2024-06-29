package com.bagusrizki.ainun.ui

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bagusrizki.ainun.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.bagusrizki.ainun.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        enableEdgeToEdge()

        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isIndoorLevelPickerEnabled = true
        mMap.uiSettings.isCompassEnabled = true
        mMap.uiSettings.isMapToolbarEnabled = true

        // Check location permissions
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
            return
        }

        mMap.isMyLocationEnabled = true

        fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
            location?.let {
                val currentLatLng = LatLng(it.latitude, it.longitude)
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 12f))
            }
        }

        // Get latitude and longitude from intent
        val latitude = intent.getDoubleExtra("LATITUDE", 0.0)
        val longitude = intent.getDoubleExtra("LONGITUDE", 0.0)
        val locationName = intent.getStringExtra("LOCATION_NAME")
        val hari = intent.getStringExtra("LOCATION_HARI")
        val jam = intent.getStringExtra("LOCATION_JAM")
        val alamat = intent.getStringExtra("LOCATION_ALAMAT")
        val telp = intent.getStringExtra("LOCATION_TELP")
        if (latitude != 0.0 && longitude != 0.0) {
            val selectedLatLng = LatLng(latitude, longitude)
            mMap.addMarker(
                MarkerOptions().position(selectedLatLng).title(locationName)
                    .snippet(alamat)
            )
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(selectedLatLng, 12f))

            binding.tvLocationName.text = locationName ?: "Selected Location"
            binding.tvHari.text = "Lat: $latitude, Lon: $longitude"
            binding.tvHari.text = hari
            binding.tvAlamat.text = alamat
            binding.tvJam.text = jam
            binding.tvTelp.text = telp

        }


    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }


}
