package com.example.actionhistory.taskmanager.controller;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.actionhistory.R;
import com.example.actionhistory.model.AppDatabase;
import com.example.actionhistory.taskmanager.model.Task;

public class TaskFormActivity extends AppCompatActivity {

    private EditText inputTaskTitle, inputTaskDescription, inputCreatedAt;
    private CheckBox inputIsCompleted;

    private Task currentTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_form);

        inputTaskTitle = findViewById(R.id.inputTaskTitle);
        inputTaskDescription = findViewById(R.id.inputTaskDescription);
        inputCreatedAt = findViewById(R.id.inputCreatedAt);
        inputIsCompleted = findViewById(R.id.inputIsCompleted);
        Button btnSaveTask = findViewById(R.id.btnSaveTask);

        AppDatabase db = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "task_manager_db"
        ).allowMainThreadQueries().build();

        int taskId = getIntent().getIntExtra("task_id", -1);

        if (taskId != -1) {
            currentTask = db.taskDao().getTaskById(taskId);
            fillFormForEditing();
        }

        btnSaveTask.setOnClickListener(v -> saveOrUpdateTask());
    }

    private void fillFormForEditing() {
        inputTaskTitle.setText(currentTask.getTaskTitle());
        inputTaskDescription.setText(currentTask.getTaskDescription());
        inputCreatedAt.setText(currentTask.getCreatedAt());
        inputIsCompleted.setChecked(currentTask.isCompleted());
    }

    private void saveOrUpdateTask() {
        TaskController controller = new TaskController(this);

        String title = inputTaskTitle.getText().toString().trim();
        String createdAt = inputCreatedAt.getText().toString().trim();

        if (title.isEmpty()) {
            Toast.makeText(this, "El título no puede estar vacío.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (createdAt.isEmpty()) {
            Toast.makeText(this, "La fecha de creación no puede estar vacía.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (currentTask == null) {

            Task newTask = new Task();
            newTask.setTaskTitle(title);
            newTask.setTaskDescription(inputTaskDescription.getText().toString().trim());
            newTask.setCreatedAt(createdAt);
            newTask.setCompleted(inputIsCompleted.isChecked());

            controller.insertTask(newTask);
            Toast.makeText(this, "Tarea creada.", Toast.LENGTH_SHORT).show();

        } else {

            currentTask.setTaskTitle(title);
            currentTask.setTaskDescription(inputTaskDescription.getText().toString().trim());
            currentTask.setCreatedAt(createdAt);
            currentTask.setCompleted(inputIsCompleted.isChecked());

            controller.updateTask(currentTask);
            Toast.makeText(this, "Tarea actualizada.", Toast.LENGTH_SHORT).show();
        }


        finish();
    }
}
