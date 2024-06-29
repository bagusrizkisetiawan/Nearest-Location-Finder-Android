package com.bagusrizki.ainun

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bagusrizki.ainun.databinding.ItemArtikelBinding

class ArtikelAdapter(private var artikel: List<ArtikelData>) :
    RecyclerView.Adapter<ArtikelAdapter.ArtikelViewHolder>() {

    class ArtikelViewHolder(val binding: ItemArtikelBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtikelViewHolder {
        val binding = ItemArtikelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArtikelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtikelViewHolder, position: Int) {
        val artikelItem = artikel[position]
        holder.binding.apply {
            tvJudul.text = artikelItem.judul
            tvKeterangan.text = artikelItem.keterangan

            // Uncomment and adjust the click listener if needed
            // cardLocation.setOnClickListener {
            //     val context = it.context
            //     val intent = Intent(context, MapsActivity::class.java).apply {
            //         putExtra("LATITUDE", artikelItem.latitude)
            //         putExtra("LONGITUDE", artikelItem.longitude)
            //         putExtra("LOCATION_NAME", artikelItem.name)
            //         putExtra("LOCATION_HARI", artikelItem.hari)
            //         putExtra("LOCATION_JAM", artikelItem.jam)
            //         putExtra("LOCATION_ALAMAT", artikelItem.alamat)
            //         putExtra("LOCATION_TELP", artikelItem.no_telp)
            //     }
            //     context.startActivity(intent)
            // }
        }
    }

    override fun getItemCount() = artikel.size

    fun updateArtikels(newArtikels: List<ArtikelData>) {
        artikel = newArtikels
        notifyDataSetChanged()
    }
}
