package com.example.moodtherapist

import android.widget.Toast
import com.example.shared.BaseRecyclerActivity
import com.example.shared.Task
import com.google.firebase.database.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shared.TaskAdapter

class MainActivity : BaseRecyclerActivity() {

    private lateinit var dbRef: DatabaseReference
    private val tasks = mutableListOf<Task>()

    override fun onStart() {
        super.onStart()
        titleText.text = "Task List"
        actionButton.text = "Refresh"
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TaskAdapter(tasks)

        loadTasks()
        recyclerView.adapter = TaskAdapter(tasks, showDoneButton = true) { task ->
            val ref = FirebaseDatabase.getInstance().getReference("tasks").child(task.id)
            ref.child("status").setValue("done")
        }

    }

    private fun loadTasks() {
        dbRef = FirebaseDatabase.getInstance().getReference("tasks")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                tasks.clear()
                for (taskSnapshot in snapshot.children) {
                    val task = taskSnapshot.getValue(Task::class.java)
                    task?.let { tasks.add(it) }
                }
                recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity, "Erreur de chargement ❌", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onActionPressed() {
        loadTasks()
    }
}
