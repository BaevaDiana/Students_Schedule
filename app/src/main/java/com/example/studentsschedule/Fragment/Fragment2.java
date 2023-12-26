package com.example.studentsschedule.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.studentsschedule.NotesActivity;
import com.example.studentsschedule.Page1Activity;
import com.example.studentsschedule.Page2Activity;
import com.example.studentsschedule.R;

public class Fragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_2, container, false);

        Button buttonNumerator = rootView.findViewById(R.id.button_numerator);
        Button buttonDenominator = rootView.findViewById(R.id.button_denominator);
        Button buttonNotes = rootView.findViewById(R.id.button_notes);

        buttonNumerator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Page1Activity.class);
                startActivity(intent);
            }
        });

        buttonDenominator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Page2Activity.class);
                startActivity(intent);
            }
        });

        buttonNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NotesActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
