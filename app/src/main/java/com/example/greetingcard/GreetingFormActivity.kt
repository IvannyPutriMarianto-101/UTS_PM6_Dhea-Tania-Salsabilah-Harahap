package com.example.greetingcard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class GreetingFormActivity : AppCompatActivity() {

    // Menggunakan lateinit untuk variabel non-nullable
    private lateinit var etGreetingMessage: EditText
    private lateinit var etRecipientName: EditText
    private lateinit var etPersonalMessage: EditText
    private lateinit var etClosingMessage: EditText
    private lateinit var etSenderName: EditText
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting_form)

        // Inisialisasi EditTexts dan Button
        etGreetingMessage = findViewById(R.id.et_greeting_message)
        etRecipientName = findViewById(R.id.et_recipient_name)
        etPersonalMessage = findViewById(R.id.et_personal_message)
        etClosingMessage = findViewById(R.id.et_closing_massage) // Memastikan ID sesuai
        etSenderName = findViewById(R.id.et_sender_name)
        btnSubmit = findViewById(R.id.btn_submit)

        // Set OnClickListener untuk Button
        btnSubmit.setOnClickListener {
            // Mengambil nilai dari setiap EditText
            val greetingMessage = etGreetingMessage.text.toString()
            val recipientName = etRecipientName.text.toString()
            val personalMessage = etPersonalMessage.text.toString()
            val closingMessage = etClosingMessage.text.toString()
            val senderName = etSenderName.text.toString()

            // Membuat Intent untuk berpindah ke GreetingDisplayActivity
            val intent = Intent(this, GreetingDisplayActivity::class.java).apply {
                putExtra("EXTRA_GREETING_MESSAGE", greetingMessage)
                putExtra("EXTRA_RECIPIENT_NAME", recipientName)
                putExtra("EXTRA_PERSONAL_MESSAGE", personalMessage)
                putExtra("EXTRA_CLOSING_MESSAGE", closingMessage)
                putExtra("EXTRA_SENDER_NAME", senderName)
            }

            // Memulai Activity dengan Intent
            startActivity(intent)
        }
    }
}
