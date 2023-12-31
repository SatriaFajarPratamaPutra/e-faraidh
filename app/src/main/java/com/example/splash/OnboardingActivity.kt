package com.example.splash

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OnboardingActivity : AppCompatActivity() {
    private lateinit var button1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding) // Mengatur tata letak untuk aktivitas onboarding

        val textViewClickable = findViewById<TextView>(R.id.idlewati)
        textViewClickable.setOnClickListener {
            val intent = Intent(this, OnboardingActivity3::class.java)
            startActivity(intent)
            finish()
        }

        button1 = findViewById(R.id.selanjutnya)
        button1.setOnClickListener {
            val intent = Intent(this, OnboardingActivity2::class.java)
            startActivity(intent)
            finish()
        }
    }
}
