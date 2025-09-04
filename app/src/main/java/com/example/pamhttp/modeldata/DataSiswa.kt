package com.example.mydatasiswa.modeldata

import kotlinx.serialization.Serializable

@Serializable
data class DataSiswa(
    val id : Int,
    val nama : String,
    val alamat : String,
    val telpn : String
)
data class UIStateSiswa(
    val detailSiswa: DetailSiswa = DetailSiswa(),
    val isEntryValid: Boolean = false
)

data class DetailSiswa (
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val telpn: String = "",
)
fun DetailSiswa.toDataSiswa(): DataSiswa = DataSiswa (
    id = id,
    nama = nama,
    alamat = alamat,
    telpn = telpn,
)
fun DataSiswa.toUiStateSiswa(isEntryValid: Boolean = false): UIStateSiswa = UIStateSiswa (
    detailSiswa = this.toDetailSiswa(),
    isEntryValid = isEntryValid
)
fun DataSiswa.toDetailSiswa(): DetailSiswa = DetailSiswa (
    id = id,
    nama = nama,
    alamat = alamat,
    telpn = telpn
)