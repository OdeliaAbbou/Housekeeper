package com.example.moodclient

import android.content.Intent
import android.widget.Button
import android.widget.Toast
import com.example.shared.BaseInputActivity
import com.example.shared.Task
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class MainActivity : BaseInputActivity() {

    override fun onStart() {
        super.onStart()
        titleText.text = "Add New Task"
        actionButton.text = "Send ✉️"


        val id = resources.getIdentifier("btnAllTasks", "id", packageName)
        if (id != 0) {
            val btnAllTasks = findViewById<Button>(id)
            btnAllTasks?.setOnClickListener {
                val intent = Intent(this, TaskListActivity::class.java)
                startActivity(intent)
            }
        } else {
            Toast.makeText(this, "Bouton introuvable", Toast.LENGTH_SHORT).show()
        }


    }

    override fun onActionPressed() {
        val taskText = inputText.text.toString().trim()
        if (taskText.isNotEmpty()) {
            val ref = FirebaseDatabase.getInstance().getReference("tasks")
            val id = ref.push().key ?: UUID.randomUUID().toString()
            val task = Task(id, taskText, "pending", System.currentTimeMillis())
            ref.child(id).setValue(task).addOnSuccessListener {
                Toast.makeText(this, "Tâche envoyée ✅", Toast.LENGTH_SHORT).show()
                inputText.text.clear()
            }.addOnFailureListener {
                Toast.makeText(this, "Erreur d’envoi 😢", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Écris une tâche d'abord !", Toast.LENGTH_SHORT).show()
        }
    }
}
