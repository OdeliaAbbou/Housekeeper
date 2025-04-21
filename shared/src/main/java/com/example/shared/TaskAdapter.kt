package com.example.shared

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shared.R

class TaskAdapter(
    private val tasks: List<Task>,
    private val showDoneButton: Boolean = false,
    private val onTaskDone: ((Task) -> Unit)? = null
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text: TextView = view.findViewById(R.id.tvTaskText)
        val status: TextView = view.findViewById(R.id.tvTaskStatus)
        val btnDone: Button = view.findViewById(R.id.btnDone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.text.text = task.text
        holder.status.text = "Statut : ${task.status}"

        if (showDoneButton && task.status != "done") {
            holder.btnDone.visibility = View.VISIBLE
            holder.btnDone.setOnClickListener {
                onTaskDone?.invoke(task)
            }
        } else {
            holder.btnDone.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int = tasks.size
}
