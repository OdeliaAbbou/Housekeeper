package com.example.moodtherapist.ui.theme;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shared.R;
import com.example.shared.Task;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private final List<Task> taskList;

    public TaskAdapter(List<Task> tasks) {
        this.taskList = tasks;
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView statusView;

        public TaskViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tvTaskText);
            statusView = itemView.findViewById(R.id.tvTaskStatus);
        }
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.textView.setText(task.getText());
        holder.statusView.setText("Statut : " + task.getStatus());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
