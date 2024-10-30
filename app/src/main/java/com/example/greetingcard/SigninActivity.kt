package com.example.greetingcard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SigninActivity : AppCompatActivity() {

    // Menggunakan lateinit untuk variabel non-nullable
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        // Inisialisasi EditText dan Button
        etEmail = findViewById(R.id.et_your_email)
        etPassword = findViewById(R.id.et_your_pass)
        btnSignUp = findViewById(R.id.btn_signup)

        // Listener untuk tombol Sign Up
        btnSignUp.setOnClickListener {
            // Ambil input dari EditText
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // Ambil data pendaftaran dari SharedPreferences
            val sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)
            val registeredEmail = sharedPreferences.getString("email", "")
            val registeredPassword = sharedPreferences.getString("password", "")

            // Validasi login
            if (email == registeredEmail && password == registeredPassword) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

                // Arahkan ke GreetingFormActivity jika login berhasil
                val intent = Intent(this, GreetingFormActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
