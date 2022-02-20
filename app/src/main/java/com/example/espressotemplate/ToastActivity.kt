package com.example.espressotemplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class ToastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)
    }

    fun makeAToast(view: View) {
        val text = "Toast is displayed"
        val duration = Toast.LENGTH_SHORT

        Toast.makeText(applicationContext, text, duration).show()
    }
}