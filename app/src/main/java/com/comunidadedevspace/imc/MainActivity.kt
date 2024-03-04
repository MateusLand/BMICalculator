package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.whenCreated
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtWeight = findViewById<TextInputEditText>(R.id.edt_weight)
        val edtHeight = findViewById<TextInputEditText>(R.id.edt_height)
        val btnCalculate = findViewById<Button>(R.id.btn_calculate)

        btnCalculate.setOnClickListener {
            val weight = edtWeight.text.toString().toFloat()
            val height = edtHeight.text.toString().toFloat()

            val bmiHeight = height * height
            val bmiResult = weight / bmiHeight
            println("Test: $bmiResult")
        }
    }
}