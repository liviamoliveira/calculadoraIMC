package dev.estudos.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "CALCULADORA IMC"

        setContentView(R.layout.activity_main)
        setupInicial()
    }

    fun setupInicial(){
        btCalcularIMC.setOnClickListener {
            val peso = etPeso.text.toString().toDouble()
            val altura = etAltura.text.toString().toDouble()

            calcularIMC(peso,altura)
        }

        btRefazerCalculo.setOnClickListener {
            etPeso.setText("")
            etAltura.setText("")
        }
    }

    fun calcularIMC(peso: Double, altura: Double) {
       val resultado = peso / altura.pow(2)
        irParaResultadoPeso(resultado)
    }

    fun irParaResultadoPeso(resultado: Double) {
        val intent = Intent(this, ResultadoPesoActivity::class.java)
        intent.putExtra(PARAM_PESO, resultado)
        startActivity(intent)
    }

    companion object{
        private const val PARAM_PESO = "PARAM_PESO"
    }
}
