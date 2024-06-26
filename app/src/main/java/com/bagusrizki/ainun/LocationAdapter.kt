package com.bagusrizki.ainun

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bagusrizki.ainun.databinding.ItemLocationBinding
import com.bagusrizki.ainun.ui.MapsActivity

class LocationAdapter(private var locations: List<Pair<LocationData, Float>>) :
    RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    class LocationViewHolder(val binding: ItemLocationBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val binding = ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val (location, distance) = locations[position]
        holder.binding.apply {
            tvName.text = location.name
            tvLatLng.text = "Lat: ${location.latitude}, Lon: ${location.longitude}"
            tvKm.text = " ${"%.2f".format(distance / 1000)} "
            cardLocation.setOnClickListener(){
                val context = it.context
                val intent = Intent(context, MapsActivity::class.java).apply {
                    putExtra("LATITUDE", location.latitude)
                    putExtra("LONGITUDE", location.longitude)
                    putExtra("LOCATION_NAME", location.name)
                    putExtra("LOCATION_HARI", location.hari)
                    putExtra("LOCATION_JAM", location.jam)
                    putExtra("LOCATION_ALAMAT", location.alamat)
                    putExtra("LOCATION_TELP", location.no_telp)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount() = locations.size

    fun updateLocations(newLocations: List<Pair<LocationData, Float>>) {
        locations = newLocations
        notifyDataSetChanged()
    }
}
