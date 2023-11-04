package com.example.splash

import android.os.Handler
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private val SPLASH_TIMEOUT: Long = 3000 // Waktu tampilan splash screen (dalam milidetik)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen) // Mengatur tata letak untuk aktivitas splash screen

        // Handler digunakan untuk menunda proses selama SPLASH_TIMEOUT (3000 milidetik atau 3 detik).
        Handler().postDelayed({
            // Setelah waktu SPLASH_TIMEOUT berlalu, buat Intent untuk memulai aktivitas berikutnya.
            val intent = Intent(this, LoginPageActivity::class.java)
            startActivity(intent) // Memulai aktivitas OnboardingActivity.
            finish() // Menyelesaikan aktivitas splash screen agar tidak dapat diakses kembali setelah berpindah ke aktivitas berikutnya.
        }, SPLASH_TIMEOUT)
    }
}
