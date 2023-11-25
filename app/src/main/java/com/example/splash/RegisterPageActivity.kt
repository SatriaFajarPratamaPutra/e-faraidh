package com.example.splash

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterPageActivity : AppCompatActivity() {

    private lateinit var input_1: EditText
    private lateinit var input_2: EditText
    private lateinit var input_3: EditText
    private lateinit var input_4: EditText
    private lateinit var button_1: Button

    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page) // Mengatur tata letak untuk aktivitas register page

        val textViewClickable2 = findViewById<TextView>(R.id.textregister2)
        textViewClickable2.setOnClickListener {
            val intent = Intent(this, LoginPageActivity::class.java)
            startActivity(intent)
            finish()
        }

        input_1 = findViewById(R.id.input_1)
        input_2 = findViewById(R.id.input_2)
        input_3 = findViewById(R.id.input_3)
        input_4 = findViewById(R.id.input_4)
        button_1 = findViewById(R.id.masuk)

        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://e-faraidh-64b88-default-rtdb.firebaseio.com/")

        button_1.setOnClickListener {
            val nama: String = input_1.text.toString()
            val email: String = input_2.text.toString()
            val password: String = input_3.text.toString()
            val password2: String = input_4.text.toString()

            if (nama.isEmpty() || email.isEmpty() || password.isEmpty() || password2.isEmpty()) {
                Toast.makeText(applicationContext, "Ada Data Yang Masih Kosong!!", Toast.LENGTH_SHORT).show()
            } else if (password != password2) {
                Toast.makeText(applicationContext, "Password dan Konfirmasi Password tidak cocok!!", Toast.LENGTH_SHORT).show()
            } else {
                database = FirebaseDatabase.getInstance().getReference("users")
                database.child(nama).child("name").setValue(nama)
                database.child(nama).child("email").setValue(email)
                database.child(nama).child("password").setValue(password)
                database.child(nama).child("konfirm password").setValue(password2)
                Toast.makeText(applicationContext, "Register Berhasil", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, HomepageActivity::class.java)
                startActivity(intent)
            }
        }

    }
}