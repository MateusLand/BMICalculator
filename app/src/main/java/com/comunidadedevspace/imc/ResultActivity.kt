package com.comunidadedevspace.imc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

const val KEY_RESULT_BMI = "ResultActivity.KEY_BMI"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_BMI, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_Result)
        val tvClassification = findViewById<TextView>(R.id.tv_Classification)
        val btnRecalculate = findViewById<Button>(R.id.btn_Recalculate)

        tvResult.text = result.toString()

        val classification = when {
            result < 18.5f -> {
                // Set color for Underweight (Red)
                tvClassification.setTextColor(ContextCompat.getColor(this, R.color.colorRed))
                "Underweight"
            }
            result in 18.5f..24.9f -> {
                // Set color for Normal (Green)
                tvClassification.setTextColor(ContextCompat.getColor(this, R.color.colorGreen))
                "NORMAL"
            }
            result in 25f..29.9f -> {
                // Set color for Overweight (Yellow)
                tvClassification.setTextColor(ContextCompat.getColor(this, R.color.colorYellow))
                "OVERWEIGHT"
            }
            result in 30f..39.9f -> {
                // Set color for Obesity (Red)
                tvClassification.setTextColor(ContextCompat.getColor(this, R.color.colorRed))
                "OBESITY"
            }
            else -> {
                // Set color for Extreme Obesity (Red)
                tvClassification.setTextColor(ContextCompat.getColor(this, R.color.colorRed))
                "EXTREME OBESITY"
            }
        }

        btnRecalculate.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        tvClassification.text = classification
    }
}