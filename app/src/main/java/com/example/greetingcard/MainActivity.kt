package com.example.greetingcard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.example.greetingcard.R
import com.example.greetingcard.SignupActivity

class MainActivity : AppCompatActivity() {

    // Menggunakan lateinit untuk inisialisasi nanti di onCreate
    private lateinit var btnGetStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi tombol
        btnGetStart = findViewById(R.id.btn_getstart)

        // Set OnClickListener untuk pindah ke SignupActivity
        btnGetStart.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}
