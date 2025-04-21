package com.example.shared

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.shared.R

abstract class BaseSimpleActivity : AppCompatActivity() {

    protected lateinit var titleText: TextView
    protected lateinit var actionButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker)

        titleText = findViewById(R.id.tvTitle)
        actionButton = findViewById(R.id.btnAction)

        actionButton.setOnClickListener {
            onActionPressed()
        }
    }

    abstract fun onActionPressed()
}
