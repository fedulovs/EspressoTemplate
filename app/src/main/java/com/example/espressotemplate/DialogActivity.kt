package com.example.espressotemplate

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input

class DialogActivity : AppCompatActivity() {
    private val TAG: String = "AppDebug"

    private lateinit var launchDialogButton: Button
    private lateinit var textName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        launchDialogButton = findViewById(R.id.button_launch_dialog)
        textName = findViewById(R.id.text_name)

        launchDialogButton.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog(){
        MaterialDialog(this)
            .show {
                input (
                    waitForPositiveButton = true,
                    allowEmpty = false
                ){ dialog, name ->
                    setNameToTextView(name.toString())
                }
                title(R.string.text_enter_name)
                positiveButton(R.string.text_ok)
            }
    }

    private fun setNameToTextView(name: String){
        textName.text = name
    }
}