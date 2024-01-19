package com.example.implementasiintent

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView

class MoveActivityObject: Activity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val receivedPerson: Person? = intent.getParcelableExtra("person")

        if (receivedPerson != null) {
            val name = receivedPerson.name
            val age = receivedPerson.grade

            val tvResult = findViewById<TextView>(R.id.tv_result)
            tvResult.text = "Name: $name, Grade: $age"
        }


    }

}