package com.example.diceapp

class inheritance {

    fun main(){
        val lamborghini = MyCarChoice(2000000, "White")
        val ferrari = MyCarChoice(2200000, "White", "Ferrari")
        with(lamborghini){
            println("\nLamborghini\n############")
            println("My car color: $color")
            println("My car name: $name")
            println("The cost of my car: ${cost()}")
        }
        with(ferrari){
            println("\nFerrari\n############")
            println("My car color: $color")
            println("My car name: $name")
            println("The cost of my car: ${cost()}")
        }
    }
}

abstract class Car(private val actualCarCost: Int){
    abstract val cashForPapers: Int
    fun cost(): Int {
        return cashForPapers + actualCarCost
    }

}

class MyCarChoice(actualCarCost: Int, val color: String, val name: String = "Lamborghini")
    : Car(actualCarCost){
    override  val cashForPapers = 100000
}