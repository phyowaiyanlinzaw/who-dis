package me.phyo.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class QuizUIActivity : AppCompatActivity(), View.OnClickListener {

    private var mainQuestion : TextView? = null
    private var image : ImageView? = null
    private var progressBar : ProgressBar? = null
    private var progressBarText : TextView? =null
    private var option1 : TextView? = null
    private var option2 : TextView? = null
    private var option3 : TextView? = null
    private var option4 : TextView? = null
    private var questionsList : ArrayList<Question>? = null
    private var currentPosition : Int = 1
    private var selectedOptionPosition : Int = 0
    private var submitBTN : Button? = null
    private var correctAnswer : Int = 0
    private var userName:String? =null
    private var isAnyOptionSelected : Boolean = false
    private var numberArraysRandom = listOf<Int>(0,1,2,3,4,5,6,7,8,9).toMutableList().shuffled()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_uiactivity)

        mainQuestion = findViewById(R.id.txv_question)
        image = findViewById(R.id.imv_question)
        progressBar = findViewById(R.id.progressBar)
        progressBarText = findViewById(R.id.progressBar_txv)
        option1 = findViewById(R.id.option_one)
        option2 = findViewById(R.id.option_two)
        option3 = findViewById(R.id.option_three)
        option4 = findViewById(R.id.option_four)
        submitBTN = findViewById(R.id.submitBtn)
        userName = intent.getStringExtra(Constants.USER_NAME)

        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)
        submitBTN?.setOnClickListener(this)
        questionsList = Constants.getQuestions()
        setQuestion()
        Log.i("Hi", numberArraysRandom.toString())
    }

    private fun setQuestion() {
        defaultOptions()
        val realQuestions = questionsList!![numberArraysRandom[currentPosition-1]]
        progressBar?.progress = currentPosition
        mainQuestion?.text = realQuestions.question
        image?.setImageResource(realQuestions.image)
        progressBarText?.text = "$currentPosition of ${progressBar?.max}"
        option1?.text = realQuestions.optionOne
        option2?.text = realQuestions.OptionTwo
        option3?.text = realQuestions.OptionThree
        option4?.text = realQuestions.OptionFour
        submitBTN?.text = "SUBMIT"

    }

    private fun defaultOptions(){
        val options = ArrayList<TextView>()
        option1?.let {
            options.add(0,it)
        }
        option2?.let {
            options.add(1,it)
        }
        option3?.let {
            options.add(2,it)
        }
        option4?.let {
            options.add(3,it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#313638"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this@QuizUIActivity,R.drawable.default_option_border_background
            )
        }
    }

    private fun selectedOptions(tv:TextView,selectedNum:Int){
        defaultOptions()
        selectedOptionPosition = selectedNum
        tv.setTextColor((Color.parseColor("#363A43")))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,R.drawable.selected_option_border_background
        )
    }

    override fun onClick(view: View?) {
        when (view?.id) {

            R.id.option_one -> {
                option1?.let {
                    selectedOptions(it, 1)
                    isAnyOptionSelected = true
                }


            }

            R.id.option_two -> {
                option2?.let {
                    selectedOptions(it, 2)
                    isAnyOptionSelected = true
                }

            }

            R.id.option_three -> {
                option3?.let {
                    selectedOptions(it, 3)
                    isAnyOptionSelected = true
                }

            }

            R.id.option_four -> {
                option4?.let {
                    selectedOptions(it, 4)
                    isAnyOptionSelected = true
                }

            }

            R.id.submitBtn->{
                if (isAnyOptionSelected){
                if (selectedOptionPosition == 0) {
                    isAnyOptionSelected = false
                    currentPosition++
                    when {
                        currentPosition <= questionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,userName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,correctAnswer)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,questionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else {
                    val question = questionsList?.get(numberArraysRandom[currentPosition-1])
                    if (question!!.correctAnswer != selectedOptionPosition) {
                        answerView(selectedOptionPosition, R.drawable.wrong_option_border_background)
                    }
                    else {
                        correctAnswer++
                    }
                    answerView(question.correctAnswer, R.drawable.right_option_border_background)

                    if (currentPosition == questionsList!!.size) {
                        submitBTN?.text = "FINISH"
                    } else {
                        submitBTN?.text = "NEXT QUESTION"
                    }
                    selectedOptionPosition = 0

                }}
                    else{
                        Toast.makeText(this,"Please Choose At Least One Option",Toast.LENGTH_LONG).show()
                    }
            }
        }
    }

    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                option1?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2->{
                option2?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3->{
                option3?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4->{
                option4?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
    }