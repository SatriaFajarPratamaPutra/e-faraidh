package com.example.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class WelcomePageKalkulator : AppCompatActivity() {
    private lateinit var imgbutton1: ImageButton
    private lateinit var button1: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator_welcomepage) // Mengatur tata letak untuk aktivitas pendahuluan expanded

        imgbutton1 = findViewById(R.id.arrowback)
        imgbutton1.setOnClickListener {
            val intent = Intent(this, HomepageActivity::class.java)
            startActivity(intent)
            finish()
        }

        button1 = findViewById(R.id.mulaihitung)
        button1.setOnClickListener {
            val intent = Intent(this, Page1Kalkulator::class.java)
            startActivity(intent)
            finish()
        }
    }
}
