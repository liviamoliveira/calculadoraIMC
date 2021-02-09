package dev.estudos.calculadoraimc.di

import org.koin.core.module.Module

object AppModule {
    fun getModules(): List<Module> = listOf(
        uiModule,
        dataModule
    )
}