package com.example.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class Page1Kalkulator : AppCompatActivity() {
    private lateinit var imgbutton1: ImageButton
    private lateinit var button1: Button
    private lateinit var rblakilaki: RadioButton
    private lateinit var rbperempuan: RadioButton
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator_page1) // Mengatur tata letak untuk aktivitas pendahuluan expanded

        imgbutton1 = findViewById(R.id.arrowback)
        imgbutton1.setOnClickListener {
            val intent = Intent(this, WelcomePageKalkulator::class.java)
            startActivity(intent)
            finish()
        }

        rblakilaki = findViewById(R.id.rblakilaki)
        rbperempuan = findViewById(R.id.rbperempuan)
        rblakilaki.isChecked = false
        rbperempuan.isChecked = false

//        // Set listener untuk radio group
//        val rgJenisKelamin = findViewById<RadioGroup>(R.id.rg_jeniskelaminpewaris)
//        rgJenisKelamin.setOnCheckedChangeListener { group, checkedId ->
//            // Jika radio button "Laki-laki" dipilih
//            if (checkedId == R.id.rblakilaki) {
//                // Nonaktifkan radio button "Perempuan"
//                rbperempuan.isChecked = false
//            }
//            // Jika radio button "Perempuan" dipilih
//            else if (checkedId == R.id.rbperempuan) {
//                // Nonaktifkan radio button "Laki-laki"
//                rblakilaki.isChecked = false
//            }
//        }


        button1 = findViewById(R.id.selanjutnya)
        button1.setOnClickListener {
            val intent = Intent(this, Page2Kalkulator::class.java)
            startActivity(intent)
            finish()
        }
    }
}
