package dev.estudos.calculadoraimc.resultado

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import dev.estudos.calculadoraimc.R
import kotlinx.android.synthetic.main.activity_resultado_peso.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResultadoPesoActivity : AppCompatActivity() {

    private val viewModel by viewModel<ResultadoPesoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_peso)

        title = "CALCULADORA IMC"

        setUpInicial()
        verificarObservers()
        parametrosIniciais()
    }

    private fun setUpInicial() {
        btVoltarCalculo.setOnClickListener{
            finish()
        }
    }

    private fun verificarObservers() {
        viewModel.exibirResultadoSucesso.observe(this, Observer {
            exibirCor(R.color.green_app)
            exibirValor(it)
            exibirMensagens("PARABÉNS!!!!", "PARABÉNS!!! Você está dentro do peso ideal.")
        })
        viewModel.exibirResultadoCuidadoMagreza.observe(this, Observer {
            exibirCor(R.color.red)
            exibirValor(it)
            exibirMensagens("CUIDADO!!!!", "CUIDADO!!! Você está num nível alto de Magreza.")
        })
        viewModel.exibirResultadoAtencaoMagreza.observe(this, Observer {
            exibirCor(R.color.yellow)
            exibirValor(it)
            exibirMensagens("ATENÇÃO!!!!", "ATENÇÃO!!! Você está abaixo do peso.")
        })
        viewModel.exibirResultadoAtencaoSobrepeso.observe(this, Observer {
            exibirCor(R.color.yellow)
            exibirValor(it)
            exibirMensagens("ATENÇÃO!!!!", "ATENÇÃO!!! Você está com sobrepreso.")
        })
        viewModel.exibirResultadoCuidadoObeso.observe(this, Observer {
            exibirCor(R.color.red)
            exibirValor(it)
            exibirMensagens("CUIDADO!!!!", "CUIDADO!!! Você está obeso.")
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

    fun parametrosIniciais() {
        val resultadoPeso = intent.getStringExtra(PARAM_PESO) ?: "0.00"
        viewModel.verificarIMC(resultadoPeso.replace(",", ".").toDouble())
    }

    companion object {
        private const val PARAM_PESO = "PARAM_PESO"
    }
}