package com.example.mydatasiswa.modeldata

import kotlinx.serialization.Serializable

@Serializable
data class DataSiswa(
    val id: String,
    val nama: String,
    val alamat: String,
    val telpn: String
)
