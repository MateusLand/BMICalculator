package com.comunidadedevspace.imc

import android.content.Intent
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

            if (weightStr.isEmpty() || heightStr.isEmpty()) {

                Snackbar.make(
                    edtWeight,
                    "Fields cannot be empty",
                    Snackbar.LENGTH_SHORT
                ).show()

            } else {
                val weight = weightStr.toFloat()
                val height = heightStr.toFloat()

                val finalHeight = height * height
                val bmiResult = weight / finalHeight

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_BMI, bmiResult)
                startActivity(intent)
            }
        }
    }
}
