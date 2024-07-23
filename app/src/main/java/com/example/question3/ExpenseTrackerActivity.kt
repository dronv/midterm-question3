package com.example.question3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ExpenseTrackerActivity : AppCompatActivity() {

    private var groceryTotal = 0.0
    private var utilitiesTotal = 0.0
    private var personalTotal = 0.0
    private var entertainmentTotal = 0.0
    private var selectedCategory = "Grocery"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.expense)

        val spinner: Spinner = findViewById(R.id.spSelect)
        val amountEditText: EditText = findViewById(R.id.edAmount)
        val addButton: Button = findViewById(R.id.btAdd)
        val groceryAmountTextView: TextView = findViewById(R.id.GNum)
        val utilitiesAmountTextView: TextView = findViewById(R.id.utilitiesAmount)
        val personalAmountTextView: TextView = findViewById(R.id.personalAmount)
        val entertainmentAmountTextView: TextView = findViewById(R.id.entertainmentAmount)

        val categories = arrayOf("Grocery", "Utilities", "Personal", "Entertainment")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedCategory = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        addButton.setOnClickListener {
            val amountStr = amountEditText.text.toString().trim()
            if (amountStr.isEmpty()) return@setOnClickListener

            val amount = amountStr.toDouble()
            when (selectedCategory) {
                "Grocery" -> {
                    groceryTotal += amount
                    groceryAmountTextView.text = groceryTotal.toString()
                }
                "Utilities" -> {
                    utilitiesTotal += amount
                    utilitiesAmountTextView.text = utilitiesTotal.toString()
                }
                "Personal" -> {
                    personalTotal += amount
                    personalAmountTextView.text = personalTotal.toString()
                }
                "Entertainment" -> {
                    entertainmentTotal += amount
                    entertainmentAmountTextView.text = entertainmentTotal.toString()
                }
            }
            amountEditText.text.clear()
        }

    }
}
