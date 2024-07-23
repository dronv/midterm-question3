package com.example.question3

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calc)
        val edNum1: EditText = findViewById(R.id.edNum1)
        val edNum2: EditText = findViewById(R.id.edNum2)
        val resultView: TextView = findViewById(R.id.resultView)
        val spinner: Spinner = findViewById(R.id.spinner)
        val resultBtn: Button = findViewById(R.id.ResultBtn)
        ArrayAdapter.createFromResource(
            this,
            R.array.operations,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        resultBtn.setOnClickListener {
            val num1 = edNum1.text.toString().toInt()
            val num2 = edNum2.text.toString().toInt()
            val operation = spinner.selectedItem.toString()
            if (num1 != null && num2 != null) {
                val result = when (operation) {
                    "Addition" -> add(num1, num2)
                    "Subtraction" -> sub(num1, num2 )
                    "Multiplication" -> multiply(num1, num2)
                    "Division" -> {
                        if (num2 != 0)
                            divide(num1, num2)
                        else "Error!"
                    }
                    else -> "Invalid"
                }
                resultView.text = result.toString()
            } else {
                resultView.text = "Invalid"
            }
        }
    }
}

public fun add (a: Int, b: Int): Int {
    return a+b
}

public fun sub (a: Int, b: Int): Int {
    return a-b
}
public fun divide (a: Int, b: Int): Int {
    return a/b
}
public fun multiply (a: Int, b: Int): Int {
    return a*b
}