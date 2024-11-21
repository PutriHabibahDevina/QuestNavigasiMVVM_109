package com.example.praktikum5.viewmodel

import androidx.lifecycle.ViewModel
import com.example.praktikum5.model.DataSiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SiswaViewModel : ViewModel() {
    //Request
    private val _statusUI = MutableStateFlow(DataSiswa()) //DataSiswa itu model

    //Response
    val statusUI: StateFlow<DataSiswa> = _statusUI.asStateFlow()//statusUI untuk akses oleh si view

    fun saveDataSiswa(ls: MutableList<String>){
        _statusUI.update { statusSaatIni -> //statusSaatIni isinya adalah sebuah model yaitu DataSiswa
            statusSaatIni.copy(
                nim = ls[0],
                nama = ls[1],
                gender = ls[2],
                alamat = ls[3],
                email = ls[4],
                notelepon = ls[5],
            )
        }
    }
}