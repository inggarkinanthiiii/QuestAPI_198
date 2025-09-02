package com.example.pamhttp.apiservice

import com.example.mydatasiswa.modeldata.DataSiswa

import retrofit2.http.GET

interface ServiceApiSiswa {
    @GET("bacaTeman.php")
    suspend fun getSiswa(): List<DataSiswa>
}