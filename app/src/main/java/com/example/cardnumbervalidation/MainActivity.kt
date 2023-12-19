package com.example.cardnumbervalidation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextCardNumber: EditText = findViewById(R.id.editTextCardNumber)
        val buttonValidate: Button = findViewById(R.id.buttonValidate)

        fun validate(number:String):Boolean{
            val numbers = number.filter { it.isDigit() }.reversed()
            var sum: Int = 0
            val parity: Int = numbers.length % 2
            for (i in numbers.indices) {
                var digit = numbers[i].digitToInt()
                if ((i+1) % 2 == parity) {
                    digit *= 2
                    if (digit > 9) digit-=9
                }
                sum+=digit
            }
            return sum%10==0
        }

        buttonValidate.setOnClickListener {
            val cardNumber = editTextCardNumber.text.toString()
            val isValid = validate(cardNumber)
            if (isValid) {
                Toast.makeText(this, "Номер карты корректен.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Номер карты некорректен.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}