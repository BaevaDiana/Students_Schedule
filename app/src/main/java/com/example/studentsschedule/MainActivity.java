package com.example.studentsschedule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;

import java.util.Locale;
//public class MainActivity extends AppCompatActivity {
//    private static final String PREFS_FILE_NAME = "";
//    private static final String SELECTED_LANGUAGE_KEY = "";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        String savedLanguage = getAppLanguage();
//        applyLanguage(savedLanguage);
//
//        setContentView(R.layout.activity_main);
//
//        Button buttonNumerator = findViewById(R.id.button_numerator);
//        Button buttonDenominator = findViewById(R.id.button_denominator);
//        Button buttonNotes = findViewById(R.id.button_notes);
//        buttonNumerator.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Page1Activity.class);
//                startActivity(intent);
//            }
//        });
//
//        buttonDenominator.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Page2Activity.class);
//                startActivity(intent);
//            }
//        });
//
//        buttonNotes.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, NotesActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == R.id.action_russian) {
//            setLocale("ru");
//            return true;
//        } else if (item.getItemId() == R.id.action_english) {
//            setLocale("en");
//            return true;
//        } else {
//            return super.onOptionsItemSelected(item);
//        }
//    }
//
//    private void setLocale(String languageCode) {
//        // Сохранение выбранного языка в SharedPreferences
//        SharedPreferences prefs = getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
//        prefs.edit().putString(SELECTED_LANGUAGE_KEY, languageCode).apply();
//
//        // Применение нового языка
//        applyLanguage(languageCode);
//
//        // Перезапуск активности (требуется только для некоторых изменений, например, изменения языка)
//        Intent refreshIntent = new Intent(this, MainActivity.class);
//        refreshIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(refreshIntent);
//        finish();
//    }
//
//    private void applyLanguage(String languageCode) {
//        // Установка новой локали
//        Locale locale = new Locale(languageCode);
//        Locale.setDefault(locale);
//        Configuration config = new Configuration();
//        config.setLocale(locale);
//        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
//    }
//
//    private String getAppLanguage() {
//        // Используем язык, сохраненный в SharedPreferences
//        SharedPreferences prefs = getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
//        return prefs.getString(SELECTED_LANGUAGE_KEY, "ru");
//    }
//
//
//}

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String PREFS_FILE_NAME = "";
    private static final String SELECTED_LANGUAGE_KEY = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String savedLanguage = getAppLanguage();
        applyLanguage(savedLanguage);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_russian) {
            setLocale("ru");
            return true;
        } else if (item.getItemId() == R.id.action_english) {
            setLocale("en");
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void applyLanguage(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }

    private String getAppLanguage() {
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE_NAME, MODE_PRIVATE);
        return prefs.getString(SELECTED_LANGUAGE_KEY, "ru");
    }

    private void setLocale(String language) {
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_FILE_NAME, MODE_PRIVATE).edit();
        editor.putString(SELECTED_LANGUAGE_KEY, language);
        editor.apply();

        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
        finish();
    }
}

