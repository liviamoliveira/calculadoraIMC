package dev.estudos.calculadoraimc.resultado

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.estudos.calculadoraimc.R
import kotlinx.android.synthetic.main.activity_resultado_peso.*

class ResultadoPesoActivity : AppCompatActivity() {

    private lateinit var viewModel: ResultadoPesoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "CALCULADORA IMC"

        viewModel = ResultadoPesoViewModel()

        setContentView(R.layout.activity_resultado_peso)
        setupInicial()
        parametrosIniciais()
    }

    fun setupInicial(){

    }

    fun parametrosIniciais(){
        val resultadoPeso = intent.getStringExtra(PARAM_PESO) ?: "0.00"

        tvValor.text = resultadoPeso

    }

    companion object{
        private const val PARAM_PESO = "PARAM_PESO"
    }
}