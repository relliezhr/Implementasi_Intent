package com.example.implementasiintent

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MoveActivityWithData: Activity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        val tvDataReceived: TextView = findViewById<TextView>(R.id.data_received)
        val imageResource = intent.getIntExtra("imageResource", 0)

        val name = intent.getStringExtra(EXTRA_NAME, )
        val age = intent.getIntExtra(EXTRA_AGE, 0)
        val address = intent.getStringExtra(EXTRA_ADDRESS, )
        val sch = intent.getStringExtra(EXTRA_SCHOOL, )

        if (imageResource != 0) {
            val imageView: ImageView = findViewById(R.id.image)
            imageView.setImageResource(imageResource)
        }

        val text = "Name: $name\nAge: $age\nAddress: $address\nSchool: $sch"
        tvDataReceived.text = text

    }

    companion object {
        const val EXTRA_SCHOOL = "extra_school"
        const val EXTRA_ADDRESS = "extra_address"
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }
}