package com.example.actionhistory.controller;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.actionhistory.R;
import com.example.actionhistory.model.History;

import java.util.List;

public class HistoryListActivity extends AppCompatActivity {

    private HistoryController controller;
    private RecyclerView recyclerHistory;

    private Spinner spinnerAction;
    private EditText inputDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_list);

        spinnerAction = findViewById(R.id.spinnerAction);
        inputDate = findViewById(R.id.inputDate);
        Button btnFilter = findViewById(R.id.btnFilter);
        recyclerHistory = findViewById(R.id.recyclerHistory);

        recyclerHistory.setLayoutManager(new LinearLayoutManager(this));

        controller = new HistoryController(this);

        ArrayAdapter<CharSequence> spinnerAdapter =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.history_actions,
                        android.R.layout.simple_spinner_item
                );
        spinnerAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );
        spinnerAction.setAdapter(spinnerAdapter);

        btnFilter.setOnClickListener(v -> applyFilters());

        loadHistory();
    }


    private void applyFilters() {

        String action = spinnerAction.getSelectedItem().toString();
        String date = inputDate.getText().toString().trim();

        List<History> historyList =
                controller.getFilteredHistory(action, date);

        HistoryAdapter adapter = new HistoryAdapter(historyList);
        recyclerHistory.setLayoutManager(new LinearLayoutManager(this));
        recyclerHistory.setAdapter(adapter);
    }





    private void loadHistory() {
        List<History> historyList = controller.getAllHistory();
        HistoryAdapter adapter = new HistoryAdapter(historyList);
        recyclerHistory.setAdapter(adapter);
    }

}
