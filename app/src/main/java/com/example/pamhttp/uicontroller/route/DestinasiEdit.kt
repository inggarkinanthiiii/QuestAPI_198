package com.example.pamhttp.uicontroller.route

import com.example.pamhttp.R
import com.example.pamhttp.uicontroller.DestinasiNavigasi

object DestinasiEdit : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_siswa
    const val itemIdArgs = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArgs}"
}