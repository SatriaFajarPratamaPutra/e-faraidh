package com.example.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


class Page6Kalkulator : AppCompatActivity()  {
    private lateinit var imageButton1: ImageButton
    private lateinit var button1: ImageButton
    private lateinit var button2: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator_page6)

        imageButton1 = findViewById(R.id.back)
        imageButton1.setOnClickListener {
            val intent = Intent(this, Page5Kalkulator::class.java)
            startActivity(intent)
            finish()
        }

        button1 = findViewById(R.id.hitungwaris)
        button1.setOnClickListener {
            val intent = Intent(this, Page1Kalkulator::class.java)
            startActivity(intent)
            finish()
        }

        button2 = findViewById(R.id.selanjutnya)
        button2.setOnClickListener {
            val intent = Intent(this, HomepageActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}