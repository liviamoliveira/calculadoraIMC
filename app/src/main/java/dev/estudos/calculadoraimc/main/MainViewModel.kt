package dev.estudos.calculadoraimc.main

import androidx.lifecycle.ViewModel
import kotlin.math.pow

class MainViewModel : ViewModel() {

    fun calcularIMC(peso: Double, altura: Double): String {
        val resultado = (peso / altura.pow(2))
        return "%.2f".format(resultado)
    }

}