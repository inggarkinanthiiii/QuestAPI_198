package com.example.pamhttp.viewmodel

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mydatasiswa.modeldata.DataSiswa
import com.example.pamhttp.repositori.RepositoryDataSiswa
import com.example.pamhttp.uicontroller.route.DestinasiDetail
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import retrofit2.Response

sealed interface StatusUIDetail {
    data class Success(val satusiswa : DataSiswa) : StatusUIDetail
    object Loading : StatusUIDetail
    object Error : StatusUIDetail

}

class DetailViewModel(savedStateHandle: SavedStateHandle, private val repositoryDataSiswa: RepositoryDataSiswa): ViewModel(){
    private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiDetail.itemIdArgs])
    var statusUIDetail: StatusUIDetail by mutableStateOf(StatusUIDetail.Loading)
        private set
    init {
        getSatuSiswa()
    }

    fun getSatuSiswa(){
        viewModelScope.launch {
            statusUIDetail = StatusUIDetail.Loading
            statusUIDetail = try {
                StatusUIDetail.Success(satusiswa = repositoryDataSiswa.getSatuSiswa(idSiswa))
            }
            catch (g: IOException){
                StatusUIDetail.Error
            }
            catch (g: HttpException){
                StatusUIDetail.Error
            }
        }
    }
    @SuppressLint("SuspiciousIndetation")
    suspend fun hapusSatuSiswa(){
        val resp: Response<Void> = repositoryDataSiswa.hapusSatuSiswa(idSiswa)
        if (resp.isSuccessful){
            println("Sukses Hapus Data : ${resp.message()}")
        }else{
            println("Gagal Hapus Data : ${resp.errorBody()}")
        }
    }
}
