package com.example.shared

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.shared.R

abstract class BaseRecyclerActivity : AppCompatActivity() {

    protected lateinit var titleText: TextView
    protected lateinit var actionButton: Button
    protected lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker) // ce layout contient le RecyclerView

        titleText = findViewById(R.id.tvTitle)
        actionButton = findViewById(R.id.btnAction)
        recyclerView = findViewById(R.id.rvTasks)

        actionButton.setOnClickListener {
            onActionPressed()
        }
    }

    abstract fun onActionPressed()
}
