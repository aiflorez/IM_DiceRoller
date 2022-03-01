package com.example.diceroller

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val nlucky = 3
        val diceRoll = dice.roll()
        val resultNumber: TextView = findViewById(R.id.txNumber)
        resultNumber.text = diceRoll.toString()

        val resultLucky: TextView = findViewById(R.id.txLucky)
        when(diceRoll)
        {
            1 -> resultLucky.text ="So sorry! You rolled a 1. Try again!"
            2 -> resultLucky.text ="So sorry! You rolled a 2. Try again!"
            nlucky -> resultLucky.text ="You are a winner!!!"
            4 -> resultLucky.text ="So sorry! You rolled a 4. Try again!"
            5 -> resultLucky.text ="So sorry! You rolled a 5. Try again!"
            6 -> resultLucky.text ="So sorry! You rolled a 6. Try again!"
        }

        if(diceRoll==nlucky)
        {
            resultLucky.setTextColor(Color.GREEN)
        }else
        {
            resultLucky.setTextColor(Color.RED)
        }
    }
}

class Dice (val numSides: Int)
{
    //Metodo para obtener el número random desde el 1 hasta el numero indicado
    fun roll(): Int {
        return (1..numSides).random()
    }
}