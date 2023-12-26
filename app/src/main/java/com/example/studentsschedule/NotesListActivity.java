package com.example.studentsschedule;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class NotesListActivity extends AppCompatActivity {
    private ListView mListView;
    private NotesAdapter mAdapter;
    private NoteDataBase mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_list);

        // Инициализация базы данных
        mDatabaseHelper = new NoteDataBase(this);

        // Инициализация ListView
        mListView = findViewById(R.id.notes_list);

        // Получение списка заметок из базы данных
        List<Task> taskList = mDatabaseHelper.getTasks();

        // Инициализация адаптера
        mAdapter = new NotesAdapter(this, taskList);
        mListView.setAdapter(mAdapter);
    }
}
