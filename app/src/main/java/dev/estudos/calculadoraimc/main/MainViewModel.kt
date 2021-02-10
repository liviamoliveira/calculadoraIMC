package dev.estudos.calculadoraimc.main

import androidx.lifecycle.ViewModel
import dev.estudos.calculadoraimc.model.CalculadoraIMC
import kotlin.math.pow

class MainViewModel : ViewModel() {

    val calculadoraIMC = CalculadoraIMC()

    fun calcularIMC(peso: Double, altura: Double): Double {
        val resultado = calculadoraIMC.calcularIMC(peso, altura)
        return resultado
    }

}