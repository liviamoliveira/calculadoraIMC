package dev.estudos.calculadoraimc.resultado

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import dev.estudos.calculadoraimc.R
import kotlinx.android.synthetic.main.activity_resultado_peso.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import dev.estudos.calculadoraimc.model.TipoResultado.*

class ResultadoPesoActivity : AppCompatActivity() {

    private val viewModel by viewModel<ResultadoPesoViewModel>()

    class ResultadoConfig(val cor: Int, val avaliacao: String, val mensagem: String)

    val resultadoConfigs = mapOf(
        MAGREZA to ResultadoConfig(R.color.green_app, "CUIDADO!!!", "Você está num nível alto de Magreza."),
        ABAIXO_DO_PESO to ResultadoConfig(R.color.green_app, "ATENÇÃO!!!", "Você está abaixo do peso."),
        PESO_IDEAL to ResultadoConfig(R.color.green_app, "PARABÉNS!!!", "Você está dentro do peso ideal."),
        SOBREPESO to ResultadoConfig(R.color.green_app, "ATENÇÃO!!!", "Você está com sobrepreso."),
        OBESIDADE to ResultadoConfig(R.color.green_app, "CUIDADO!!!", "Você está obeso.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_peso)

        title = "CALCULADORA IMC"

        setUpInicial()
        verificarObservers()
        parametrosIniciais()
    }

    fun parametrosIniciais() {
        val resultadoPeso = intent.getDoubleExtra(PARAM_PESO, 0.0)
        viewModel.verificarIMC(resultadoPeso)
    }

    private fun setUpInicial() {
        btVoltarCalculo.setOnClickListener{
            finish()
        }
    }

    private fun verificarObservers() {
        viewModel.exibirResultado.observe(this, Observer { resultado ->
            val resultadoConfig = resultadoConfigs[resultado.tipoResultado]!!

            exibirCor(resultadoConfig.cor)
            exibirValor(resultado.imc)
            exibirMensagens(resultadoConfig.avaliacao, resultadoConfig.mensagem)
        })
    }

    private fun exibirMensagens(avaliacao:String, mensagem: String) {
        tvAvaliacao.text = avaliacao
        tvMsgDinamica.text = mensagem
    }

    private fun exibirValor(it: Double) {
        tvValor.text = it.toString()
    }

    private fun exibirCor(color: Int) {
        tvValor.setTextColor(ContextCompat.getColor(this, color))
        tvMsgDinamica.setTextColor(ContextCompat.getColor(this, color))
    }

    companion object {
        private const val PARAM_PESO = "PARAM_PESO"
    }
}