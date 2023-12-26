package com.example.studentsschedule;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;


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

                    // Отображение сообщения об успешном добавлении заметки
                    Toast.makeText(NotesActivity.this, "Заметка успешно добавлена", Toast.LENGTH_SHORT).show();

                    // Переход на новую страницу
//                    Intent intent = new Intent(NotesActivity.this, NotesListActivity.class);
//                    startActivity(intent);
                }
            }
        });

            // Получение ссылки на кнопку "Удалить заметку"
            Button buttonDeleteNote = findViewById(R.id.delete_note_button);

            // Установка слушателя нажатий на кнопку "Удалить заметку"
            buttonDeleteNote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText noteNumberEditText = findViewById(R.id.note_number_edit_text);

                    String noteNumber = noteNumberEditText.getText().toString();

                    if (noteNumber.isEmpty()) {
                        Toast.makeText(NotesActivity.this, "Введите номер заметки", Toast.LENGTH_SHORT).show();
                    } else {
                        int number = Integer.parseInt(noteNumber);

                        // Удаление заметки из базы данных
                        mDatabaseHelper.deleteTask(number);

                        // Удаление заметки из списка
                        for (int i = 0; i < mAdapter.mTaskList.size(); i++) {
                            Task task = mAdapter.mTaskList.get(i);

                            if (task.getId() == number) {
                                mAdapter.mTaskList.remove(i);
                                break;
                            }
                        }

                        // Обновление списка заметок
                        mAdapter.notifyDataSetChanged();
                        noteNumberEditText.setText("");

                        // Отображение сообщения об успешном удалении заметки
                        Toast.makeText(NotesActivity.this, "Заметка успешно удалена", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        // Получение ссылки на кнопку "Изменить заметку"
        Button buttonEditNote = findViewById(R.id.edit_note_button);

// Установка слушателя нажатий на кнопку "Изменить заметку"
        buttonEditNote.setOnClickListener(new View.OnClickListener() {
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
                    mDatabaseHelper.editTask(number, subject, note);

                    // Обновление списка заметок
                    mAdapter.mTaskList.clear();
                    mAdapter.mTaskList.addAll(mDatabaseHelper.getTasks());
                    mAdapter.notifyDataSetChanged();

                    noteNumberEditText.setText("");
                    subjectEditText.setText("");
                    noteEditText.setText("");

                    // Отображение сообщения об успешном изменении заметки
                    Toast.makeText(NotesActivity.this, "Заметка успешно изменена", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}
