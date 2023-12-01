package com.example.dicodingkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListDestinationAdapter(private val listDestination: ArrayList<Destination>) : RecyclerView.Adapter<ListDestinationAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_destination, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, alamat, telepon, website, deskripsi, photo) = listDestination[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvAlamat.text = alamat
        holder.tvTelp.text = telepon
        holder.tvWeb.text = website
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listDestination[holder.adapterPosition]) }

    }

    override fun getItemCount(): Int = listDestination.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvAlamat: TextView = itemView.findViewById(R.id.tv_item_alamat)
        val tvTelp: TextView = itemView.findViewById(R.id.tv_item_telp)
        val tvWeb: TextView = itemView.findViewById(R.id.tv_item_web)

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Destination)
    }
}