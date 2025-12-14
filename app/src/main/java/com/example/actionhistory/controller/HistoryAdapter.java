package com.example.actionhistory.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.actionhistory.R;
import com.example.actionhistory.model.History;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private final List<History> historyList;

    public HistoryAdapter(List<History> historyList) {
        this.historyList = historyList;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_history, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        History history = historyList.get(position);

        holder.textAction.setText(history.getAction());
        holder.textDate.setText(history.getCreatedAt());
        holder.textDetails.setText(history.getDetails());
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    static class HistoryViewHolder extends RecyclerView.ViewHolder {

        TextView textAction, textDate, textDetails;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            textAction = itemView.findViewById(R.id.textAction);
            textDate = itemView.findViewById(R.id.textDate);
            textDetails = itemView.findViewById(R.id.textDetails);
        }
    }

}
