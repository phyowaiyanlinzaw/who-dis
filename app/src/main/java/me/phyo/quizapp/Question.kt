package me.phyo.quizapp

data class Question(
    val id: Int,
    val question: String,
    val image : Int,
    val optionOne : String,
    val OptionTwo : String,
    val OptionThree : String,
    val OptionFour : String,
    val correctAnswer : Int
)
