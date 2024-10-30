package com.example.greetingcard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {

    // Menggunakan lateinit untuk variabel non-nullable
    private lateinit var etFullName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnSignup: Button
    private lateinit var tvSignIn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // Inisialisasi EditText dan Button
        etFullName = findViewById(R.id.et_greeting_message)
        etEmail = findViewById(R.id.et_recipient_name)
        etPassword = findViewById(R.id.et_personal_message)
        etConfirmPassword = findViewById(R.id.confirm_password)
        btnSignup = findViewById(R.id.btn_signup)
        tvSignIn = findViewById(R.id.signin)

        // Listener untuk tombol Sign Up
        btnSignup.setOnClickListener {
            val fullName = etFullName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            // Validasi input
            when {
                fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() -> {
                    Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                }
                password != confirmPassword -> {
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    // Simpan data ke SharedPreferences
                    val sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putString("fullName", fullName)
                    editor.putString("email", email)
                    editor.putString("password", password)
                    editor.apply()

                    Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show()

                    // Pindah ke LoginActivity (atau MainActivity)
                    val intent = Intent(this, SigninActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }

        // Listener untuk Sign In text
        tvSignIn.setOnClickListener {
            // Arahkan ke LoginActivity
            val intent = Intent(this, SigninActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
