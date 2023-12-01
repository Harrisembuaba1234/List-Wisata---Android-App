package com.example.dicodingkotlin

import android.os.Parcelable
import android.provider.ContactsContract.CommonDataKinds.Website
import kotlinx.parcelize.Parcelize

@Parcelize
data class Destination(
    val name: String,
    val alamat: String,
    val telepon: String,
    val website: String,
    val deskripsi: String,
    val photo: Int
) : Parcelable

