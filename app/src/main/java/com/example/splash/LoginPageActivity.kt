package com.example.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class LoginPageActivity : AppCompatActivity() {

    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var loginButton: Button
    private lateinit var imageButtonTogglePassword1: ImageButton

    private lateinit var database: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        inputEmail = findViewById(R.id.input_1)
        inputPassword = findViewById(R.id.input_2)
        loginButton = findViewById(R.id.masuk)
        imageButtonTogglePassword1 = findViewById(R.id.eye1)
        val editTextPassword1 = findViewById<EditText>(R.id.input_2)

        // Tambahkan event listener untuk eye1 (imageButtonTogglePassword1)
        imageButtonTogglePassword1.setOnClickListener {
            togglePasswordVisibility(editTextPassword1, imageButtonTogglePassword1)
        }

        database = FirebaseDatabase.getInstance().getReference("users")

        loginButton.setOnClickListener {
            val nama = inputEmail.text.toString().trim()
            val password = inputPassword.text.toString().trim()

            if (nama.isEmpty() || password.isEmpty()) {
                Toast.makeText(applicationContext, "Username Atau Password Salah",
                    Toast.LENGTH_SHORT).show()
            } else {
                database.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.child(nama).exists()) {
                            if (snapshot.child(nama).child("password").getValue(String::class.java) == password) {
                                Toast.makeText(applicationContext, "Login Berhasil",
                                    Toast.LENGTH_SHORT).show()

                                // Simpan informasi pengguna yang berhasil masuk untuk penggunaan selanjutnya
                                val masuk = Intent(applicationContext, HomepageActivity::class.java)
                                masuk.putExtra("USER_ID", nama)
                                val user = snapshot.child(nama)
                                masuk.putExtra("USER_NAME", user.child("name").getValue(String::class.java))
                                masuk.putExtra("USER_EMAIL", user.child("email").getValue(String::class.java))
                                masuk.putExtra("USER_PASSWORD", user.child("password").getValue(String::class.java))
                                startActivity(masuk)

                            } else {
                                Toast.makeText(applicationContext, "Password Salah",
                                    Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(applicationContext, "Data Belum Terdaftar",
                                Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(applicationContext, "Operasi Database Dibatalkan: " + error.message,
                            Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }

        setTouchListener()
    }

    private fun togglePasswordVisibility(editTextPassword: EditText, imageButtonTogglePassword: ImageButton) {
        // Ubah visibilitas teks di EditText
        if (editTextPassword.transformationMethod == PasswordTransformationMethod.getInstance()) {
            // Jika sekarang teks tersembunyi, tampilkan teks
            editTextPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
        } else {
            // Jika sekarang teks terlihat, sembunyikan teks
            editTextPassword.transformationMethod = PasswordTransformationMethod.getInstance()
        }

        // Set kursor ke posisi terakhir pada teks
        editTextPassword.setSelection(editTextPassword.text.length)
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


