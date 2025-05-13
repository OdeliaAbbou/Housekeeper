package com.example.shared;

public class Task {
    private String id;
    private String text;
    private String status;
    private long timestamp;


    public Task() {
    }

    public Task(String id, String text, String status, long timestamp) {
        this.id = id;
        this.text = text;
        this.status = status;
        this.timestamp = timestamp;
    }

    public Task(String text) {
        this.text = text;
        this.status = "pending";
        this.timestamp = System.currentTimeMillis();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
