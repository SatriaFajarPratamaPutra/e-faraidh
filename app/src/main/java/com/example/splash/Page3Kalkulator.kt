package com.example.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Page3Kalkulator : AppCompatActivity() {
    private lateinit var imgbutton1: ImageButton
    private lateinit var button1: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator_page3) // Mengatur tata letak untuk aktivitas pendahuluan expanded

        imgbutton1 = findViewById(R.id.arrowback)
        imgbutton1.setOnClickListener {
            val intent = Intent(this, Page2Kalkulator::class.java)
            startActivity(intent)
            finish()
        }

        button1 = findViewById(R.id.selanjutnya)
        button1.setOnClickListener {
            val intent = Intent(this, Page4Kalkulator::class.java)
            startActivity(intent)
            finish()
        }
        setTouchListener()
    }

    private fun setTouchListener() {
        val view = findViewById<View>(android.R.id.content)
        view.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                hideKeyboard()
            }
            false
        }
    }

    private fun hideKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
}
