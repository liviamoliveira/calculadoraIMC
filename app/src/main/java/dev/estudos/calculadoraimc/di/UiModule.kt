package dev.estudos.calculadoraimc.di

import dev.estudos.calculadoraimc.main.MainViewModel
import dev.estudos.calculadoraimc.resultado.ResultadoPesoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { ResultadoPesoViewModel() }
    viewModel { MainViewModel() }
}