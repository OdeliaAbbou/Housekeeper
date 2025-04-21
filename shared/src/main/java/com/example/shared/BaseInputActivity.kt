package com.example.shared

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.shared.R

abstract class BaseInputActivity : AppCompatActivity() {

    protected lateinit var titleText: TextView
    protected lateinit var inputText: EditText
    protected lateinit var actionButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base) // Le layout utilisé contient un EditText

        titleText = findViewById(R.id.tvTitle)
        inputText = findViewById(R.id.etInput)
        actionButton = findViewById(R.id.btnAction)

        actionButton.setOnClickListener {
            onActionPressed()
        }





    }

    abstract fun onActionPressed()
}
