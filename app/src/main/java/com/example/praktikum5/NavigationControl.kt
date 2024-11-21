package com.example.praktikum5

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.praktikum5.model.JenisKelamin.jenisK
import com.example.praktikum5.view.FormulirView
import com.example.praktikum5.view.TampilDataView
import com.example.praktikum5.viewmodel.SiswaViewModel

enum class Halaman {
    FORMULIR,
    TAMPILDATA
}

@Composable
fun NavigationControl(
    modifier: Modifier = Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
){
    //parameter untuk mendapatkan data/mengakses view model
    val uiState by viewModel.statusUI.collectAsState()

    NavHost(
        navController = navHost,
        startDestination = Halaman.FORMULIR.name,
    ){
        composable(
            route = Halaman.FORMULIR.name
        ){
            val konteks = LocalContext.current
            FormulirView(listJK = jenisK.map { id ->
                konteks.getString(id)
            },
                onSubmitClicked = {
                    viewModel.saveDataSiswa(it)
                    navHost.navigate(Halaman.TAMPILDATA.name)
                }
            )
        }
        composable(route = Halaman.TAMPILDATA.name) {
            TampilDataView(uiState = uiState, onBackButton = { navHost.popBackStack()})
        }
    }
}