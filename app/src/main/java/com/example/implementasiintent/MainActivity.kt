package com.example.implementasiintent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val name: String?,
    val grade: Int?
) : Parcelable

class MainActivity : Activity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveDataActivity: Button = findViewById(R.id.btn_move_data_activity)
        btnMoveDataActivity.setOnClickListener(this)

        val btnMoveObject: Button = findViewById<Button>(R.id.btn_move_object_activity)
        btnMoveObject.setOnClickListener(this)

        val btnDialNumber: Button = findViewById<Button>(R.id.btn_dial_number)
        btnDialNumber.setOnClickListener(this)

        val btnActivityResult: Button = findViewById<Button>(R.id.btn_move_result)
        btnActivityResult.setOnClickListener(this)

        val b = intent.extras
        var value = "Result"
        if (b != null)
            value = b.getString("result", "none")

        val resultTextView=findViewById<TextView>(R.id.activity_result)
        resultTextView.setText(value)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_data_activity -> {
                val moveDataIntent = Intent(this@MainActivity, MoveActivityWithData::class.java)
                val imageResource = R.drawable.img
                moveDataIntent.putExtra("imageResource", imageResource)
                moveDataIntent.putExtra(MoveActivityWithData.EXTRA_NAME, "Aurellie Azzahra")
                moveDataIntent.putExtra(MoveActivityWithData.EXTRA_AGE, 16)
                moveDataIntent.putExtra(MoveActivityWithData.EXTRA_ADDRESS, "Malang")
                moveDataIntent.putExtra(MoveActivityWithData.EXTRA_SCHOOL, "SMK Telkom Malang")
                startActivity(moveDataIntent)
            }

            R.id.btn_move_object_activity -> {
                val person = Person("Rellie", 11)

                val intent = Intent(this@MainActivity, MoveActivityObject::class.java)
                intent.putExtra("person", person)
                startActivity(intent)

            }

            R.id.btn_dial_number -> {
                val phoneNumber = "082140333911"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_move_result -> {
                val moveIntentResult = Intent(this@MainActivity, MoveActivityResult::class.java)
                startActivity(moveIntentResult)
            }
        }
    }
}