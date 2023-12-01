package com.example.dicodingkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvDestination: RecyclerView
    private val list = ArrayList<Destination>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDestination = findViewById(R.id.rv_destination)
        rvDestination.setHasFixedSize(true)




        list.addAll(getListDestination())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_profile -> {
                val intentToAbout = Intent(this@MainActivity, AboutPage::class.java)
                startActivity(intentToAbout)
            }

        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListDestination(): ArrayList<Destination> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataAlamat = resources.getStringArray(R.array.data_alamat)
        val dataTelp = resources.getStringArray(R.array.data_telepon)
        val dataWeb = resources.getStringArray(R.array.data_web)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataDeskripsi = resources.getStringArray(R.array.data_description)
        val listDestination = ArrayList<Destination>()
        for (i in dataName.indices) {
            val destination = Destination(dataName[i], dataAlamat[i], dataTelp[i], dataWeb[i], dataDeskripsi[i], dataPhoto.getResourceId(i, -1))
            listDestination.add(destination)

        }
        return listDestination
    }

    private fun showRecyclerList() {
        rvDestination.layoutManager = LinearLayoutManager(this)
        val listDestinationAdapter = ListDestinationAdapter(list)
        rvDestination.adapter = listDestinationAdapter

        listDestinationAdapter.setOnItemClickCallback(object : ListDestinationAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Destination) {
                val intentToDetail = Intent(this@MainActivity, DetailDeskripsi::class.java)
                intentToDetail.putExtra("DATA", data)
                startActivity(intentToDetail)
                showSelectedDestination(data)
            }
        })
    }

    private fun showSelectedDestination(wisata: Destination) {
        Toast.makeText(this, "Kamu memilih " + wisata.name, Toast.LENGTH_SHORT).show()
    }


}