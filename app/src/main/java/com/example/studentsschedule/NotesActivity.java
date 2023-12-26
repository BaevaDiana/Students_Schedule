package com.example.studentsschedule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import java.util.List;


public class NotesActivity extends AppCompatActivity {
    private ListView mListView;
    private NotesAdapter mAdapter;
    private NoteDataBase mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_note);

        // Инициализация базы данных
        mDatabaseHelper = new NoteDataBase(this);

        // Инициализация ListView
        mListView = findViewById(R.id.notes_list);

        // Получение списка заметок из базы данных
        List<Task> taskList = mDatabaseHelper.getTasks();

        // Инициализация адаптера
        mAdapter = new NotesAdapter(this, taskList);
        mListView.setAdapter(mAdapter);

        // Получение ссылки на кнопку
        Button buttonAddNote = findViewById(R.id.add_note_button);

        // Установка слушателя нажатий на кнопку
        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText noteNumberEditText = findViewById(R.id.note_number_edit_text);
                EditText subjectEditText = findViewById(R.id.subject_edit_text);
                EditText noteEditText = findViewById(R.id.note_edit_text);

                String noteNumber = noteNumberEditText.getText().toString();
                String subject = subjectEditText.getText().toString();
                String note = noteEditText.getText().toString();

                if (noteNumber.isEmpty() || subject.isEmpty() || note.isEmpty()) {
                    Toast.makeText(NotesActivity.this, "Введите номер заметки, название предмета и заметку", Toast.LENGTH_SHORT).show();
                } else {
                    int number = Integer.parseInt(noteNumber);
                    long id = mDatabaseHelper.addTask(number, subject, note);
                    Task task = new Task(number, subject, note);
                    mAdapter.mTaskList.add(task);

                    // Обновление списка заметок
                    mAdapter.notifyDataSetChanged();

                    noteNumberEditText.setText("");
                    subjectEditText.setText("");
                    noteEditText.setText("");

                    // Переход на новую страницу
//                    Intent intent = new Intent(NotesActivity.this, NotesListActivity.class);
//                    startActivity(intent);
                }
            }
        });

    }

}
