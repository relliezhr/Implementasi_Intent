package com.example.implementasiintent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup

class MoveActivityResult: Activity(), View.OnClickListener {
    private var number: String = "200"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_result)

        val btnActivity: Button = findViewById<Button>(R.id.btn_ok)
        btnActivity.setOnClickListener(this)
    }

    override fun onClick(v: View){
        when(v.id){
            R.id.btn_ok -> {
                selectNumber()
            }
        }
    }

    private fun selectNumber() {
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        val selectedNumber = radioGroup.checkedRadioButtonId

        number = when (selectedNumber) {
            R.id._200 -> "200"
            R.id._400 -> "400"
            R.id._150 -> "150"
            R.id._900 -> "900"
            else -> "200"
        }

        val textResult = "$number"

        val intent = Intent(this@MoveActivityResult, MainActivity::class.java)
        val b = Bundle()
        b.putString("result", textResult)
        intent.putExtras(b)
        startActivity(intent)
        finish()
    }

}