package dev.estudos.calculadoraimc.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.estudos.calculadoraimc.R
import dev.estudos.calculadoraimc.resultado.ResultadoPesoActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "CALCULADORA IMC"

        setContentView(R.layout.activity_main)
        setupInicial()
    }

    fun setupInicial(){
        btCalcularIMC.setOnClickListener {
            if(!etPeso.text.isNullOrBlank() && !etAltura.text.isNullOrBlank()){
                val peso = etPeso.text.toString().toDouble()
                val altura = etAltura.text.toString().toDouble()

                calcularIMC(peso,altura)
            }
            else{
                Toast.makeText(this, "Preencha os campos Peso e Altura.", Toast.LENGTH_SHORT).show()
            }
        }

        btRefazerCalculo.setOnClickListener {
            etPeso.setText("")
            etAltura.setText("")
        }
    }

    fun calcularIMC(peso: Double, altura: Double) {
        val resultadoIMC = viewModel.calcularIMC(peso, altura)
        irParaResultadoPeso(resultadoIMC)
    }

    fun irParaResultadoPeso(resultado: String) {
        val intent = Intent(this, ResultadoPesoActivity::class.java)
        intent.putExtra(PARAM_PESO, resultado)
        startActivity(intent)
    }

    companion object{
        private const val PARAM_PESO = "PARAM_PESO"
    }
}
