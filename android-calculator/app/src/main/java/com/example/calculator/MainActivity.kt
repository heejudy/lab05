package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editNumber1 = findViewById<EditText>(R.id.editNumber1)
        val editNumber2 = findViewById<EditText>(R.id.editNumber2)
        val textResult = findViewById<TextView>(R.id.textResult)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)

        fun getNumbers(): Pair<Double, Double>? {
            val num1 = editNumber1.text.toString().toDoubleOrNull()
            val num2 = editNumber2.text.toString().toDoubleOrNull()

            if (num1 == null || num2 == null) {
                textResult.text = "숫자를 입력하세요."
                return null
            }

            return Pair(num1, num2)
        }

        btnAdd.setOnClickListener {
            val numbers = getNumbers() ?: return@setOnClickListener
            textResult.text = "결과: ${numbers.first + numbers.second}"
        }

        btnSubtract.setOnClickListener {
            val numbers = getNumbers() ?: return@setOnClickListener
            textResult.text = "결과: ${numbers.first - numbers.second}"
        }

        btnMultiply.setOnClickListener {
            val numbers = getNumbers() ?: return@setOnClickListener
            textResult.text = "결과: ${numbers.first * numbers.second}"
        }

        btnDivide.setOnClickListener {
            val numbers = getNumbers() ?: return@setOnClickListener

            if (numbers.second == 0.0) {
                textResult.text = "0으로 나눌 수 없습니다."
            } else {
                textResult.text = "결과: ${numbers.first / numbers.second}"
            }
        }
    }
}