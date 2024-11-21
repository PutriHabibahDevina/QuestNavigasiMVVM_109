package com.example.praktikum5.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.praktikum5.model.DataSiswa

@Composable
fun TampilDataView(
    uiState: DataSiswa,
    onBackButton: () -> Unit
){
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.padding(50.dp))
        TampilData(param = "Nim", argu = uiState.nim)
        TampilData(param = "Nama", argu = uiState.nama)
        TampilData(param = "Jenis Kelamin", argu = uiState.gender)
        TampilData(param = "Alamat", argu = uiState.alamat)
        TampilData(param = "Email", argu = uiState.email)
        TampilData(param = "No Telepon", argu = uiState.nama)
        Button(onClick = onBackButton){
            Text(text = "Kembali")
        }
    }
}

@Composable
fun TampilData(param: String, argu:String){
    Column (
        modifier = Modifier.padding(16.dp)
    ){
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = param,
                modifier = Modifier.weight(0.8f)) //memberi ruang kepada elemen
            Text(text = ": ",
                modifier = Modifier.weight(0.2f))
            Text(text = argu,
                modifier = Modifier.weight(2f))
        }
    }
}