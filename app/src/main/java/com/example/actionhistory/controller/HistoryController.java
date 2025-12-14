package com.example.actionhistory.controller;

import android.content.Context;

import androidx.room.Room;

import com.example.actionhistory.model.AppDatabase;
import com.example.actionhistory.model.History;
import java.util.List;

public class HistoryController {

    private final AppDatabase db;

    public HistoryController(Context context) {
        db = Room.databaseBuilder(
                context.getApplicationContext(),
                AppDatabase.class,
                "task_manager_db"
        ).allowMainThreadQueries().build();
    }

    public void insertHistory(String action, String createdAt, String details) {
        if (action == null || action.isEmpty()) return;
        if (createdAt == null || createdAt.isEmpty()) return;

        History history = new History();
        history.setAction(action);
        history.setCreatedAt(createdAt);
        history.setDetails(details);

        db.historyDao().insertHistory(history);
    }

    public List<History> getAllHistory() {
        return db.historyDao().getAllHistory();
    }

    public List<History> getFilteredHistory(String action, String date) {

        boolean hasAction = action != null && !action.equals("All");
        boolean hasDate = date != null && !date.isEmpty();

        if (hasAction && hasDate) {
            return db.historyDao().getHistoryByActionAndDate(action, date);
        }

        if (hasAction) {
            return db.historyDao().getHistoryByAction(action);
        }

        if (hasDate) {
            return db.historyDao().getHistoryByDate(date);
        }

        return db.historyDao().getAllHistory();
    }
}

