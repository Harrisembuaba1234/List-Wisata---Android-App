package com.example.dicodingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class DetailDeskripsi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_deskripsi)

        val data = intent.getParcelableExtra<Destination>("DATA")
        Log.d("Detail Data", data?.name.toString())

        val photo = findViewById<ImageView>(R.id.imageFoto)
        val name = findViewById<TextView>(R.id.namaWisata)
        val deskripsi = findViewById<TextView>(R.id.deskripsiWisata)
        val alamat = findViewById<TextView>(R.id.dataalamat)
        val telepon = findViewById<TextView>(R.id.datatelp)
        val website = findViewById<TextView>(R.id.dataweb)


        photo.setImageResource(data?.photo!!)
        name.text = data.name
        deskripsi.text = data.deskripsi
        alamat.text = data.alamat
        telepon.text = data.telepon
        website.text = data.website
    }
}