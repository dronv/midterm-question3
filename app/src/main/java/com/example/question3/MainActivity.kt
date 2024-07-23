package com.example.question3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnExpenseTracker: Button = findViewById(R.id.btnExpenseTracker)
        val btnBMICalculator: Button = findViewById(R.id.btnCalculator)

        btnExpenseTracker.setOnClickListener {
            val intent = Intent(this, ExpenseTrackerActivity::class.java)
            startActivity(intent)
        }

        btnBMICalculator.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }
    }
}
