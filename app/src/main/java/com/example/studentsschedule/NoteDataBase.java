package com.example.studentsschedule;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class NoteDataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "notes_555.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "notes";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_SUBJECT = "subject";
    public static final String COLUMN_NOTE = "note";

    public NoteDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Метод onCreate вызывается при создании базы данных
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_SUBJECT + " TEXT, " +
                COLUMN_NOTE + " TEXT)";
        db.execSQL(createTable); // Создание таблицы в базе данных
    }

    // Метод onUpgrade вызывается при обновлении базы данных
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); // Удаление старой таблицы
        onCreate(db); // Создание новой таблицы
    }

    // Метод addTask выполняет вставку данных в базу данных
    public long addTask(int number, String subject, String note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_ID, number);
        values.put(COLUMN_SUBJECT, subject);
        values.put(COLUMN_NOTE, note);
        long id = db.insert(TABLE_NAME, null, values); // Вставка данных в таблицу
        db.close();
        return id;
    }

    // Метод deleteTask выполняет удаление данных из базы данных по id
    public void deleteTask(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[] { String.valueOf(id) });
        db.close();
    }

    // Метод getTasks возвращает список всех заметок из базы данных
    public List<Task> getTasks() {
        List<Task> taskList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                Task task = new Task();
                task.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                task.setSubject(cursor.getString(cursor.getColumnIndex(COLUMN_SUBJECT)));
                task.setNote(cursor.getString(cursor.getColumnIndex(COLUMN_NOTE)));
                taskList.add(task);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return taskList;
    }
}
