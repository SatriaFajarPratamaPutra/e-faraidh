package com.example.splash

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class LoginPageActivity : AppCompatActivity() {

    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var loginButton: Button

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        inputEmail = findViewById(R.id.input_1)
        inputPassword = findViewById(R.id.input_2)
        loginButton = findViewById(R.id.masuk)

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
                            if (snapshot.child(nama).child("password").getValue<String>(String::class.java) == password) {
                                Toast.makeText(applicationContext, "Login Berhasil",
                                    Toast.LENGTH_SHORT).show()
                                val masuk = Intent(applicationContext, HomepageActivity::class.java)
                                startActivity(masuk)
                            }
                        } else {
                            Toast.makeText(applicationContext, "Data Belum Terdaftar",
                                Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {}
                })
            }
        }
    }
}
