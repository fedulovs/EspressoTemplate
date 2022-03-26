package com.example.espressotemplate

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.espressotemplate.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {

    private lateinit var openRecyclerViewButton: Button
    private lateinit var openIntentButton: Button
    private lateinit var openImagePickerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openRecyclerViewButton = findViewById(R.id.recycler_btn)
        openIntentButton = findViewById(R.id.dialer_intent_btn)
        openImagePickerButton = findViewById(R.id.image_picker_intent_btn)


        openRecyclerViewButton.setOnClickListener {
            openRecyclerActivity()
        }

        openIntentButton.setOnClickListener {
            openIntentActivity()
        }

        openImagePickerButton.setOnClickListener {
            openImagePickerActivity()
        }
    }

    fun openLoginForm(view: View) {
        val intent = Intent(this, LoginActivity::class.java).apply {
        }
        startActivity(intent)
    }

    fun openRecyclerActivity() {
        val intent = Intent(this, RecyclerActivity::class.java).apply {
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

    private fun openImagePickerActivity() {
        val intent = Intent(this, GalleryPickerActivity::class.java).apply {
        }
        startActivity(intent)
    }
}