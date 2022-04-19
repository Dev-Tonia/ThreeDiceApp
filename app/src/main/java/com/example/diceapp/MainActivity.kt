package com.example.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.rollButton)
        button.setOnClickListener {
            rollBtn()
        }
    }

    private fun rollBtn() {
//        creating the object instance
        val dice = Dice(6)
        val diceNum1: Int = dice.diceRoll()
        val diceNum2: Int = dice.diceRoll()
        val diceNum3: Int = dice.diceRoll()

//        referencing
        val diceImg1: ImageView = findViewById(R.id.dice1)
        val diceImg2: ImageView = findViewById(R.id.dice2)
        val diceImg3: ImageView = findViewById(R.id.dice3)
        val toast1 = Toast.makeText(this, "YOU WIN", Toast.LENGTH_SHORT)
        val toast2 = Toast.makeText(this, "YOU LOSE", Toast.LENGTH_SHORT)

//        generating the value of the dice depending on the random number.
        fun  imageResult(diceSides: Int): Int {
            return when (diceSides) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
        }

//         setting the value to the screen.
        diceImg1.setImageResource(imageResult(diceNum1))
        diceImg2.setImageResource(imageResult(diceNum2))
        diceImg3.setImageResource(imageResult(diceNum3))


//        checking for the condition to win the game.
        if (diceNum1 == 6 && diceNum2 == 6 || diceNum1 == 6 && diceNum3 == 6){

            toast1.show()

        }else if (diceNum2 == 6 && diceNum1 == 6 || diceNum2 == 6 && diceNum3 == 6){

            toast1.show()

        }else if (diceNum3 == 6 && diceNum1 == 6 || diceNum3 == 6 && diceNum2 == 6){
            toast1.show()

        }

//        checking for the condition for losing the game
        if (diceNum1 + diceNum2 == 9 || diceNum1 + diceNum3 == 9){

            toast2.show()

        }else if (diceNum2 + diceNum1 == 9 || diceNum2 + diceNum3 == 9){

            toast2.show()

        }else if (diceNum3 + diceNum1 == 9 || diceNum3 + diceNum2 == 9){
            toast2.show()

        }

    }
}

class Dice(private val sides: Int){

    fun diceRoll(): Int{
        return (1..sides).random()
    }
}