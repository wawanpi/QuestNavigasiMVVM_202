package com.example.pertemuan7.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pertemuan7.Model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

//Kalok ada titik : itu berarti view model
class MahasiswaViewModel :ViewModel (){
    //karna yang menakses bukan untuk publik
    private val _uiState = MutableStateFlow(Mahasiswa())
    
    val uistate: StateFlow<Mahasiswa> = _uiState.asStateFlow()
    
    fun saveDataMahasiswa(
        ls :MutableList<String>
    ){
        _uiState.update { data ->
            data.copy(
                nama = ls[0],
                nim = ls[1],
                gender = ls[2],
                alamat = ls[3],
            )
        }
    }
}