package com.example.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Page2Kalkulator : AppCompatActivity() {
    private lateinit var imgbutton1: ImageButton
    private lateinit var button1: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator_page2) // Mengatur tata letak untuk aktivitas pendahuluan expanded

        imgbutton1 = findViewById(R.id.arrowback)
        imgbutton1.setOnClickListener {
            val intent = Intent(this, Page1Kalkulator::class.java)
            startActivity(intent)
            finish()
        }

        button1 = findViewById(R.id.selanjutnya)
        button1.setOnClickListener {
            val intent = Intent(this, Page3Kalkulator::class.java)
            startActivity(intent)
            finish()
        }
    }
}
