package dev.estudos.calculadoraimc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ResultadoPesoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "CALCULADORA IMC"

        setContentView(R.layout.activity_resultado_peso)
        setupInicial()
        parametrosIniciais()
    }

    fun setupInicial(){

    }

    fun parametrosIniciais(){
        val resultadoPeso = intent.getDoubleExtra(PARAM_PESO,0.0)

        val a = ""
    }

    companion object{
        private const val PARAM_PESO = "PARAM_PESO"
    }
}