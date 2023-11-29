package com.example.splash

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
    private lateinit var imageButtonTogglePassword1: ImageButton
    private lateinit var imageButtonTogglePassword2: ImageButton

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
        imageButtonTogglePassword1 = findViewById(R.id.eye1)
        imageButtonTogglePassword2 = findViewById(R.id.eye2)
        val editTextPassword1 = findViewById<EditText>(R.id.input_3)
        val editTextPassword2 = findViewById<EditText>(R.id.input_4)

        // Tambahkan event listener untuk eye1 (imageButtonTogglePassword1)
        imageButtonTogglePassword1.setOnClickListener {
            togglePasswordVisibility(editTextPassword1, imageButtonTogglePassword1)
        }

        // Tambahkan event listener untuk eye2 (imageButtonTogglePassword2)
        imageButtonTogglePassword2.setOnClickListener {
            togglePasswordVisibility(editTextPassword2, imageButtonTogglePassword2)
        }

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

                val intent = Intent(this, LoginPageActivity::class.java)
                startActivity(intent)
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