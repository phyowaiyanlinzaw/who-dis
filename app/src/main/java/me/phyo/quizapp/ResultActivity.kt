package me.phyo.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val finalResult:TextView = findViewById(R.id.correctAnswerTextView)
        val userName : TextView = findViewById(R.id.usernameTextView)
        val finishBtn :Button = findViewById(R.id.finishBtn)

        userName.text = intent.getStringExtra(Constants.USER_NAME)
        val correctAnswer:Int = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        val totalQuestions:Int = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)

        finalResult.text = "Your result is $correctAnswer out of $totalQuestions"

        finishBtn.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}