package com.example.splash

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView


class HomepageActivity : AppCompatActivity() {
    private lateinit var imgbutton1: ImageButton // Deklarasi imgbutton sebagai ImageButton
    private lateinit var imgbutton2: ImageButton
    private lateinit var imgbutton3: ImageButton
    private lateinit var imgbutton4: ImageButton
    private lateinit var userId: String
    private lateinit var userName: String
    private lateinit var userEmail: String
    private lateinit var userPassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        // Mendapatkan userId dari intent
        userId = intent.getStringExtra("USER_ID") ?: ""
        userName = intent.getStringExtra("USER_NAME") ?: ""
        userEmail = intent.getStringExtra("USER_EMAIL") ?: ""
        userPassword = intent.getStringExtra("USER_PASSWORD") ?: ""

        val receivedIntent = intent
        if (receivedIntent.hasExtra("USER_NAME")) {
            val userName = receivedIntent.getStringExtra("USER_NAME") ?: ""
            val text2 = findViewById<TextView>(R.id.text2) // Referensi ke TextView dengan ID text2
            text2.text = userName // Mengatur teks TextView dengan nilai userName dari Intent
        }


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
            val intent = Intent(this, ProfilPage::class.java)
            // Include all user data in the intent
            intent.apply {
                putExtra("USER_ID", userId)
                putExtra("USER_NAME", userName)
                putExtra("USER_EMAIL", userEmail)
                putExtra("USER_PASSWORD", userPassword)
            }
            startActivity(intent)
            finish()
        }

    }
}
