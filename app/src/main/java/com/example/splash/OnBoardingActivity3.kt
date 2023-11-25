package com.example.splash

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class OnboardingActivity3 : AppCompatActivity() {

    private lateinit var imgbutton: ImageButton // Deklarasi variabel imgbutton
    private lateinit var button1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding3)

        imgbutton = findViewById(R.id.imgbutton) // Inisialisasi imgbutton dengan ImageButton dari layout

        imgbutton.setOnClickListener {
            val intent = Intent(this, RegisterPageActivity::class.java)
            startActivity(intent)
            finish()
        }

        button1 = findViewById(R.id.selanjutnya)
        button1.setOnClickListener {
            val intent = Intent(this, LoginPageActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
