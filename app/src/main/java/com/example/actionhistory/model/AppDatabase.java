package com.example.actionhistory.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.actionhistory.taskmanager.model.Task;
import com.example.actionhistory.taskmanager.model.TaskDao;

@Database(
        entities = {
                Task.class,
                History.class
        },
        version = 2,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {

    public abstract TaskDao taskDao();

    public abstract HistoryDao historyDao();
}
