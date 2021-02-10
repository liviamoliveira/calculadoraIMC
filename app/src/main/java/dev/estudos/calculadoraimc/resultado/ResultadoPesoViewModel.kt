package dev.estudos.calculadoraimc.resultado

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.estudos.calculadoraimc.model.Resultado

class ResultadoPesoViewModel: ViewModel(){

    val exibirResultado = MutableLiveData<Resultado>()

    fun verificarIMC(imc: Double) {
        exibirResultado.value = Resultado(imc)
    }


}