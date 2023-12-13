package com.example.studentsschedule;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
//import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Page1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_1);

        // Получаем ссылки на TextView, которые представляют дни недели
        TextView mondayTextView = findViewById(R.id.monday_text_view);
        TextView tuesdayTextView = findViewById(R.id.tuesday_text_view);
        TextView wednesdayTextView = findViewById(R.id.wednesday_text_view);
        TextView thursdayTextView = findViewById(R.id.thursday_text_view);
        TextView fridayTextView = findViewById(R.id.friday_text_view);
        TextView saturdayTextView = findViewById(R.id.saturday_text_view);

        // Устанавливаем обработчик событий для каждого TextView
        mondayTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ваш код для вывода списка предметов на понедельник
                Toast.makeText(Page1Activity.this, "Список предметов на понедельник", Toast.LENGTH_SHORT).show();
            }
        });

        tuesdayTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ваш код для вывода списка предметов на вторник
                Toast.makeText(Page1Activity.this, "Список предметов на вторник", Toast.LENGTH_SHORT).show();
            }
        });

        wednesdayTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ваш код для вывода списка предметов на среду
                Toast.makeText(Page1Activity.this, "Список предметов на среду", Toast.LENGTH_SHORT).show();
            }
        });

        thursdayTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ваш код для вывода списка предметов на четверг
                Toast.makeText(Page1Activity.this, "Список предметов на четверг", Toast.LENGTH_SHORT).show();
            }
        });

        fridayTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ваш код для вывода списка предметов на пятницу
                Toast.makeText(Page1Activity.this, "Список предметов на пятницу", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
