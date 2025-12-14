package com.example.actionhistory.taskmanager.controller;

import android.content.Context;

import androidx.room.Room;

import com.example.actionhistory.controller.HistoryController;
import com.example.actionhistory.model.AppDatabase;
import com.example.actionhistory.taskmanager.model.Task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TaskController {

    private final AppDatabase db;
    private final HistoryController historyController;

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public TaskController(Context context) {
        db = Room.databaseBuilder(
                context.getApplicationContext(),
                AppDatabase.class,
                "task_manager_db"
        ).allowMainThreadQueries().build();

        historyController = new HistoryController(context);
    }

    private String getCurrentDate() {
        return new SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
                .format(new Date());
    }

    public void insertTask(Task task) {
        db.taskDao().insertTask(task);

        historyController.insertHistory(
                "insert_task",
                getCurrentDate(),
                task.getTaskTitle()
        );
    }

    public void updateTask(Task task) {
        db.taskDao().updateTask(task);

        historyController.insertHistory(
                "update_task",
                getCurrentDate(),
                task.getTaskTitle()
        );
    }

    public void deleteTask(Task task) {
        db.taskDao().deleteTask(task);

        historyController.insertHistory(
                "delete_task",
                getCurrentDate(),
                task.getTaskTitle()
        );
    }

    public List<Task> getAllTasks() {
        return db.taskDao().getAllTasks();
    }

    public Task getTaskById(int id) {
        return db.taskDao().getTaskById(id);
    }
}
