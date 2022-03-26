package com.example.espressotemplate

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class IntentActivity : AppCompatActivity() {

    lateinit var phoneInput: EditText
    lateinit var callButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        phoneInput = findViewById(R.id.editTextPhone)
        callButton = findViewById(R.id.make_call_button)

        callButton.setOnClickListener {
            dialPhoneNumber(phoneInput.text.toString())
        }
    }

    fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_CALL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }

        if (ActivityCompat.checkSelfPermission(
                this@IntentActivity,
                android.Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this@IntentActivity,
                arrayOf(android.Manifest.permission.CALL_PHONE),
                1
            )
        } else {
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }
}