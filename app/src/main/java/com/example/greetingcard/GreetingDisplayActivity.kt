package com.example.greetingcard

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GreetingDisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting_display)

        // Referensi TextViews
        val tvGreetingMessage = findViewById<TextView>(R.id.tv_greeting_message)
        val tvRecipientName = findViewById<TextView>(R.id.tv_recipient_name)
        val tvPersonalMessage = findViewById<TextView>(R.id.tv_personal_message)
        val tvClosingMessage = findViewById<TextView>(R.id.tv_closing_message)
        val tvSenderName = findViewById<TextView>(R.id.tv_sender_name)

        // Mendapatkan data dari Intent
        val greetingMessage = intent.getStringExtra("EXTRA_GREETING_MESSAGE")
        val recipientName = intent.getStringExtra("EXTRA_RECIPIENT_NAME")
        val personalMessage = intent.getStringExtra("EXTRA_PERSONAL_MESSAGE")
        val closingMessage = intent.getStringExtra("EXTRA_CLOSING_MESSAGE")
        val senderName = intent.getStringExtra("EXTRA_SENDER_NAME")

        // Menampilkan data ke TextViews
        tvGreetingMessage.text = greetingMessage
        tvRecipientName.text = recipientName
        tvPersonalMessage.text = personalMessage
        tvClosingMessage.text = closingMessage
        tvSenderName.text = senderName
    }
}
