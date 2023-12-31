package com.example.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MateriVideoPageActivity : AppCompatActivity() {
    private lateinit var imgbutton1: ImageButton
    private lateinit var imgbutton2: ImageButton
    private lateinit var imgbutton3: ImageButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materivideo_page) // Mengatur tata letak untuk aktivitas materi video page

        imgbutton1 = findViewById(R.id.arrowback)
        imgbutton1.setOnClickListener {
            val intent = Intent(this, HomepageActivity::class.java)
            startActivity(intent)
            finish()
        }

        imgbutton2 = findViewById(R.id.box1)
        imgbutton2.setOnClickListener {
            val intent = Intent(this, PendahuluanExpanded::class.java)
            startActivity(intent)
            finish()
        }

        imgbutton3 = findViewById(R.id.box2)
        imgbutton3.setOnClickListener {
            val intent = Intent(this, Bab2Expanded::class.java)
            startActivity(intent)
            finish()
        }
    }
}