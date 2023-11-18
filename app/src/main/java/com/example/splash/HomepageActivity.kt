package com.example.splash

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class HomepageActivity : AppCompatActivity() {
    private lateinit var imgbutton1: ImageButton // Deklarasi imgbutton sebagai ImageButton
    private lateinit var imgbutton2: ImageButton
    private lateinit var imgbutton3: ImageButton
    private lateinit var imgbutton4: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        imgbutton1 = findViewById(R.id.menu1) // Inisialisasi imgbutton dengan ImageButton dari layout
        imgbutton2 = findViewById(R.id.menu2)
        imgbutton3 = findViewById(R.id.menu3)
        imgbutton4 = findViewById(R.id.menu4)

        imgbutton1.setOnClickListener {
            val intent = Intent(this, MateriVideoPageActivity::class.java)
            startActivity(intent)
            finish()
        }

        imgbutton2.setOnClickListener {
            val intent = Intent(this, PageChat::class.java)
            startActivity(intent)
            finish()
        }

        imgbutton3.setOnClickListener {
            val intent = Intent(this, WelcomePageKalkulator::class.java)
            startActivity(intent)
            finish()
        }

        imgbutton4.setOnClickListener {
            val intent = Intent(this, RegisterPageActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

