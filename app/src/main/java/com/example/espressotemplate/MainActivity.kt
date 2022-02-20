package com.example.espressotemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.espressotemplate.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
}