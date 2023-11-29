package com.example.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class ProfilPage : AppCompatActivity() {
    private lateinit var imgbutton1: ImageButton
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page) // Mengatur tata letak untuk aktivitas pendahuluan expanded

        imgbutton1 = findViewById(R.id.arrowback)
        imgbutton1.setOnClickListener {
            val intent = Intent(this, HomepageActivity::class.java)
            startActivity(intent)
            finish()
        }
        val editTextNama = findViewById<EditText>(R.id.input_1)
        val editTextNotelp = findViewById<EditText>(R.id.input_2)
        val editTextEmail = findViewById<EditText>(R.id.input_3)
        val simpanButton = findViewById<Button>(R.id.simpanperubahan)
        lateinit var userPassword: String


        val databaseRef = FirebaseDatabase.getInstance().getReference("users")

        val receivedIntent = intent
        if (receivedIntent.hasExtra("USER_ID")) {
            val nama = receivedIntent.getStringExtra("USER_ID") ?: ""
            val userNama = receivedIntent.getStringExtra("USER_NAME") ?: ""
            val userEmail = receivedIntent.getStringExtra("USER_EMAIL") ?: ""
            userPassword = receivedIntent.getStringExtra("USER_PASSWORD") ?: ""

            editTextNama.setText(userNama)
            editTextEmail.setText(userEmail)
        }
        simpanButton.setOnClickListener {
            val namaBaru = editTextNama.text.toString().trim()
            val notelpBaru = editTextNotelp.text.toString().trim()
            val emailBaru = editTextEmail.text.toString().trim()

            // Mendapatkan USER_ID dari intent (sebelumnya disimpan saat login)
            val userId = intent.getStringExtra("USER_ID")

            if (userId != null) {
                val userRef = databaseRef.child(userId) // Menggunakan USER_ID untuk merujuk ke pengguna yang tepat

                // Salin informasi dari entri lama ke entri baru
                val dataToUpdate = HashMap<String, Any>()
                dataToUpdate["name"] = namaBaru
                dataToUpdate["notelp"] = notelpBaru
                dataToUpdate["email"] = emailBaru
                dataToUpdate["password"] = userPassword

                // Buat entri data baru
                val newUserId = namaBaru // Mendapatkan ID baru
                val newUserDataRef = databaseRef.child(newUserId ?: "")

                // Salin data lama ke data baru
                newUserDataRef.setValue(dataToUpdate)
                    .addOnSuccessListener {
                        // Jika berhasil, hapus entri lama
                        userRef.removeValue()
                            .addOnSuccessListener {
                                Toast.makeText(applicationContext, "Perubahan berhasil disimpan", Toast.LENGTH_SHORT).show()
                            }

                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(applicationContext, "Perubahan gagal disimpan: $e", Toast.LENGTH_SHORT).show()
                    }
            } else {
                Toast.makeText(applicationContext, "USER_ID tidak ditemukan", Toast.LENGTH_SHORT).show()
            }
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
