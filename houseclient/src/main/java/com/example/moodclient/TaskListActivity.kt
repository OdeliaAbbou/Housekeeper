package com.example.moodclient

import android.os.Bundle
import android.view.View
import com.example.shared.BaseRecyclerActivity
import com.example.shared.TaskAdapter
import com.example.shared.Task
import com.google.firebase.database.*
import androidx.recyclerview.widget.LinearLayoutManager

class TaskListActivity : BaseRecyclerActivity() {

    private lateinit var adapter: TaskAdapter
    private val tasks = mutableListOf<Task>()

    override fun onStart() {
        super.onStart()
        titleText.text = "All Tasks"
        actionButton.visibility = View.GONE
        recyclerView.layoutManager = LinearLayoutManager(this) // ✅ ICI

        adapter = TaskAdapter(tasks, showDoneButton = false)
        recyclerView.adapter = adapter

        loadTasks()
    }

    private fun loadTasks() {
        val ref = FirebaseDatabase.getInstance().getReference("tasks")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                tasks.clear()
                for (taskSnap in snapshot.children) {
                    val task = taskSnap.getValue(Task::class.java)
                    task?.let { tasks.add(it) }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }

    override fun onActionPressed() {
        loadTasks()
    }
}
