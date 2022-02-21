package com.example.espressotemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.espressotemplate.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {

    private lateinit var openIntentButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openIntentButton = findViewById(R.id.dialer_intent_btn)

        openIntentButton.setOnClickListener {
            openIntentActivity()
        }
    }

    fun openLoginForm(view: View) {
        val intent = Intent(this, LoginActivity::class.java).apply {
        }
        startActivity(intent)
    }

    fun openToastActivity(view: View) {
        val intent = Intent(this, ToastActivity::class.java).apply {
        }
        startActivity(intent)
    }

    fun openWebViewActivity(view: View) {
        val intent = Intent(this, WebViewActivity::class.java).apply {
        }
        startActivity(intent)
    }

    private fun openIntentActivity() {
        val intent = Intent(this, IntentActivity::class.java).apply {
        }
        startActivity(intent)
    }
}