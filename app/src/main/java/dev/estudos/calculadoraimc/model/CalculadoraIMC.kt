package dev.estudos.calculadoraimc.model

import kotlin.math.pow

class CalculadoraIMC {

    fun calcularIMC(peso: Double, altura: Double): Double {
        val resultado = (peso / altura.pow(2))
        return resultado
    }

}