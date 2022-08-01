package com.example.memorymaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cvEasy.setOnClickListener {
            val intent = Intent(this,EasyActivity::class.java)
            startActivity(intent)
        }

        cvMedium.setOnClickListener {
            val intent = Intent(this,MediumActivity::class.java)
            startActivity(intent)
        }

        cvHard.setOnClickListener {
            val intent = Intent(this,HardActivity::class.java)
            startActivity(intent)
        }
    }
}