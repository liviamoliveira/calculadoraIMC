package dev.estudos.calculadoraimc.resultado

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultadoPesoViewModel: ViewModel(){

    val exibirResultadoSucesso = MutableLiveData<Double>()
    val exibirResultadoCuidadoMagreza = MutableLiveData<Double>()
    val exibirResultadoCuidadoObeso = MutableLiveData<Double>()
    val exibirResultadoAtencaoMagreza = MutableLiveData<Double>()
    val exibirResultadoAtencaoSobrepeso = MutableLiveData<Double>()


    fun verificarIMC(resultPesoDouble: Double) {
        if (resultPesoDouble < 17.00) {
            exibirResultadoAtencaoMagreza.value = resultPesoDouble
        } else if (resultPesoDouble  >= 17.0 && resultPesoDouble < 18.5) {
            exibirResultadoCuidadoMagreza.value = resultPesoDouble
        } else if (resultPesoDouble >= 18.5 && resultPesoDouble < 25.0) {
            exibirResultadoSucesso.value = resultPesoDouble
        } else if (resultPesoDouble >= 25.0 && resultPesoDouble <= 30.0) {
            exibirResultadoAtencaoSobrepeso.value = resultPesoDouble
        } else {
            exibirResultadoCuidadoObeso.value = resultPesoDouble
        }
    }

}