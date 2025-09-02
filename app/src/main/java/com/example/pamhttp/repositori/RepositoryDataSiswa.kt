package com.example.pamhttp.repositori

import com.example.mydatasiswa.modeldata.DataSiswa
import com.example.pamhttp.apiservice.ServiceApiSiswa


interface RepositoryDataSiswa{
    suspend fun getDataSiswa() : List<DataSiswa>
}

class JaringanRepositorySiswa(
    private  val serviceApiSiswa: ServiceApiSiswa

):RepositoryDataSiswa{
    override suspend fun getDataSiswa() : List<DataSiswa> = serviceApiSiswa.getSiswa()
}