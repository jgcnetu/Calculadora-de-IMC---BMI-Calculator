package com.example.calculadoraimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {

    // Criar referências aos campos digitados na interface:
    private lateinit var txtPeso: TextView
    private lateinit var txtAltura: TextView
    private lateinit var txtResultado: TextView
    private lateinit var btnRecomecar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)

        btnRecomecar = findViewById<Button>(R.id.btn_recomecar)

        // Encontrar os campos digitados no layout XML e conectar:
        txtPeso = findViewById<TextView>(R.id.txt_peso)
        txtAltura = findViewById<TextView>(R.id.txt_altura)
        txtResultado = findViewById<TextView>(R.id.txt_resultado)

        // Recuperar os valores se os campos foram preenchidos:
        val bundle = intent.extras
        if(bundle != null){

            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            // Apresentar na tela os valores digitados pelo usuário:
            txtPeso.text = "Peso informado: $peso kg."
            txtAltura.text = "Altura informada: $altura m."

            // Fazer o calculo para o resultado final:
            val imc = peso / (altura * altura)

            // Encontrar o intervalo do resultado e destacar a faixa de peso encontrada:
            val resultado = if( imc < 18.5){
                "Baixo"
            }else if( imc >= 18.5 && imc <= 24.9){
                "Normal"
            }else if( imc >= 25.0 && imc <=29.9){
                "Sobrepeso"
            }else{
                "Obesidade"
            }

            // Apresentar o resultado final:
            txtResultado.text = resultado

            btnRecomecar.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }
    }
}