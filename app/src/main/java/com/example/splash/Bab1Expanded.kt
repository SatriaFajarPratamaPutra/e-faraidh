package com.example.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Bab1Expanded : AppCompatActivity() {
    private lateinit var imgbutton1: ImageButton
    private lateinit var imgbutton2: ImageButton
    private lateinit var imgbutton3: ImageButton
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bab1_expanded_page)

        imgbutton1 = findViewById(R.id.arrowback1)
        imgbutton1.setOnClickListener {
            val intent = Intent(this, MateriVideoPageActivity::class.java)
            startActivity(intent)
            finish()
        }

        imgbutton2 = findViewById(R.id.arrownext)
        imgbutton2.setOnClickListener {
            val intent = Intent(this, Bab2Expanded::class.java)
            startActivity(intent)
            finish()
        }

        imgbutton3 = findViewById(R.id.arrowback2)
        imgbutton3.setOnClickListener {
            val intent = Intent(this, PendahuluanExpanded::class.java)
            startActivity(intent)
            finish()
        }
    }
}
