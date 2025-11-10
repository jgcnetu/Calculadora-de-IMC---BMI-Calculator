package com.example.calculadoraimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var btnCalcular: Button
    private lateinit var textInputPeso: TextInputLayout
    private lateinit var textInputAltura: TextInputLayout
    private lateinit var edtPeso: EditText
    private lateinit var edtAltura: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular = findViewById(R.id.btn_calcular)

        // Encontrar os TextInputLayouts
        textInputPeso = findViewById(R.id.edt_peso) // ou o ID que você usou
        textInputAltura = findViewById(R.id.edt_altura) // ou o ID que você usou

        // Obter os EditText de dentro dos TextInputLayouts
        edtPeso = textInputPeso.editText as EditText
        edtAltura = textInputAltura.editText as EditText

        btnCalcular.setOnClickListener {
            val intent = Intent(this, ResultadoActivity::class.java)

            val peso = edtPeso.text.toString()
            val altura = edtAltura.text.toString()

            if(peso.isNotEmpty() && altura.isNotEmpty()){
                intent.putExtra("peso", peso.toDouble())
                intent.putExtra("altura", altura.toDouble())
                startActivity(intent)
            } else {
                // Mostrar erro se campos estiverem vazios
                if (peso.isEmpty()) {
                    textInputPeso.error = "Digite o peso"
                } else {
                    textInputPeso.error = null
                }

                if (altura.isEmpty()) {
                    textInputAltura.error = "Digite a altura"
                } else {
                    textInputAltura.error = null
                }
            }
        }
    }
}