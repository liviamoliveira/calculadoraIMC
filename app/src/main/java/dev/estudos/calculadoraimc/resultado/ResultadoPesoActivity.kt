package dev.estudos.calculadoraimc.resultado

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import dev.estudos.calculadoraimc.R
import kotlinx.android.synthetic.main.activity_resultado_peso.*

class ResultadoPesoActivity : AppCompatActivity() {

    private lateinit var viewModel: ResultadoPesoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "CALCULADORA IMC"

        viewModel = ResultadoPesoViewModel()

        setContentView(R.layout.activity_resultado_peso)
        parametrosIniciais()
    }

    fun parametrosIniciais(){
        val resultadoPeso = intent.getStringExtra(PARAM_PESO) ?: "0.00"
        tvValor.text = resultadoPeso
        verificarIMC(resultadoPeso.replace(",", ".").toDouble())
    }

    fun verificarIMC(resultPesoDouble: Double) {
        if (resultPesoDouble < 17.00) {
            tvValor.setTextColor(ContextCompat.getColor(this,R.color.red))
            tvMsgDinamica.setTextColor(ContextCompat.getColor(this,R.color.red))
            tvAvaliacao.text = "CUIDADO!!!!"
            tvMsgDinamica.text = "CUIDADO!!! Você está num nível alto de Magreza."
        } else if (resultPesoDouble == 17.0 && resultPesoDouble < 18.5) {
            tvValor.setTextColor(ContextCompat.getColor(this,R.color.yellow))
            tvMsgDinamica.setTextColor(ContextCompat.getColor(this,R.color.yellow))
            tvAvaliacao.text = "ATENÇÃO!!!!"
            tvMsgDinamica.text = "ATENÇÃO!!! Você está abaixo do peso."
        } else if (resultPesoDouble == 18.5 && resultPesoDouble < 25.0) {
            tvValor.setTextColor(ContextCompat.getColor(this,R.color.green_app))
            tvMsgDinamica.setTextColor(ContextCompat.getColor(this,R.color.green_app))
            tvAvaliacao.text = "PARABÉNS!!!!"
            tvMsgDinamica.text = "PARABÉNS!!! Você está dentro do peso ideal."
        } else if (resultPesoDouble == 25.0 && resultPesoDouble <= 30.0) {
            tvValor.setTextColor(ContextCompat.getColor(this,R.color.yellow))
            tvMsgDinamica.setTextColor(ContextCompat.getColor(this,R.color.yellow))
            tvAvaliacao.text = "ATENÇÃO!!!!"
            tvMsgDinamica.text = "ATENÇÃO!!! Você está com sobrepreso."
        } else {
            tvValor.setTextColor(ContextCompat.getColor(this,R.color.red))
            tvMsgDinamica.setTextColor(ContextCompat.getColor(this,R.color.red))
            tvAvaliacao.text = "CUIDADO!!!!"
            tvMsgDinamica.text = "CUIDADO!!! Você está obeso."
        }
    }

    companion object{
        private const val PARAM_PESO = "PARAM_PESO"
    }
}