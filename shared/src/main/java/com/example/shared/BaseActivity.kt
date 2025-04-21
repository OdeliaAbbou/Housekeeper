package com.example.shared

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.shared.R

abstract class BaseActivity : AppCompatActivity() {

    protected var titleText: TextView? = null
    protected var inputText: EditText? = null
    protected var actionButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Charge un layout différent selon le package
        if (applicationContext.packageName.contains("moodtherapist")) {
            setContentView(R.layout.activity_worker)
        } else {
            setContentView(R.layout.activity_base)
        }

        // On cherche les vues uniquement si elles existent dans le layout
        titleText = findViewById(R.id.tvTitle)
        inputText = findViewById(R.id.etInput)
        actionButton = findViewById(R.id.btnAction)

        actionButton?.setOnClickListener {
            onActionPressed()
        }
    }

    abstract fun onActionPressed()
}
