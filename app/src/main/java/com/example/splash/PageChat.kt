package com.example.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PageChat : AppCompatActivity() {
    private lateinit var imgbutton1: ImageButton
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_page) // Mengatur tata letak untuk aktivitas pendahuluan expanded

        imgbutton1 = findViewById(R.id.arrowback)
        imgbutton1.setOnClickListener {
            val intent = Intent(this, HomepageActivity::class.java)
            startActivity(intent)
            finish()
        }

        val textViewClickable = findViewById<TextView>(R.id.user2)
        textViewClickable.setOnClickListener {
            val intent = Intent(this, RoomChat::class.java)
            startActivity(intent)
            finish()
        }
    }
}
