package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtWeight = findViewById<TextInputEditText>(R.id.edt_weight)
        val edtHeight = findViewById<TextInputEditText>(R.id.edt_height)
        val btnCalculate = findViewById<Button>(R.id.btn_calculate)

        btnCalculate.setOnClickListener {


            val weightStr = edtWeight.text.toString()
            val heightStr = edtHeight.text.toString()

            if (weightStr.isNotEmpty() || heightStr.isNotEmpty()) {

                Snackbar.make(
                    edtWeight,
                    "Fields cannot be empty",
                    Snackbar.LENGTH_SHORT
                ).show()

            } else {
                val weight = weightStr.toFloat()
                val height = heightStr.toFloat()

                val bmiHeight = height * height
                val bmiResult = weight / bmiHeight
                println("Test: $bmiResult")
            }
        }
    }
}
