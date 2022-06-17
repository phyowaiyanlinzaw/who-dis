package me.phyo.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUserName : EditText = findViewById(R.id.etUserName)
        val btnStart : Button = findViewById(R.id.btnStart)

        btnStart.setOnClickListener {
            if (etUserName.text.isNotEmpty()){
            val intent = Intent(this,QuizUIActivity::class.java)
            intent.putExtra(Constants.USER_NAME,etUserName.text.toString())
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this,"Name can't be empty",Toast.LENGTH_LONG).show()
        }
        }

    }
}