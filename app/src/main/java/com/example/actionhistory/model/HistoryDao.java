package com.example.actionhistory.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HistoryDao {

    @Insert
    void insertHistory(History history);

    @Query("SELECT * FROM history ORDER BY created_at DESC")
    List<History> getAllHistory();

    // Filtrar solo por acción
    @Query("SELECT * FROM history WHERE action = :action ORDER BY created_at DESC")
    List<History> getHistoryByAction(String action);

    // Filtrar solo por fecha (YYYY-MM-DD)
    @Query("SELECT * FROM history WHERE created_at LIKE :date || '%' ORDER BY created_at DESC")
    List<History> getHistoryByDate(String date);

    // Filtrar por acción + fecha
    @Query("SELECT * FROM history WHERE action = :action AND created_at LIKE :date || '%' ORDER BY created_at DESC")
    List<History> getHistoryByActionAndDate(String action, String date);
}


