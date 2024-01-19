package com.example.implementasiintent

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MoveActivity: Activity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move)

        val greetingTextView= findViewById<TextView>(R.id.text_greeting)
        greetingTextView.text

    }

}