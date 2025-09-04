package com.example.pamhttp.apiservice

import com.example.mydatasiswa.modeldata.DataSiswa
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface ServiceApiSiswa {
    @GET("bacaTeman.php")
    suspend fun getSiswa(): List<DataSiswa>

    @POST("insertTM.php")
    suspend fun postSiswa(@Body dataSiswa: DataSiswa): retrofit2.Response<Void>

    @GET("bacaTeman.php/{id}")
    suspend fun getSatuSiswa(@Query("id") id: Int): DataSiswa

    @PUT("editTM.php")
    suspend fun editSatuSiswa(@Query("id") id: Int, @Body dataSiswa: DataSiswa): retrofit2.Response<Void>

    @DELETE("deleteTM.php/{id}")
    suspend fun hapusSatuSiswa(@Query("id") id: Int): retrofit2.Response<Void>
}
