package com.example.pamhttp.uicontroller.route

import com.example.pamhttp.R
import com.example.pamhttp.uicontroller.DestinasiNavigasi

object DestinasiDetail: DestinasiNavigasi {
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_siswa
    const val itemIdArgs = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArgs}"
}