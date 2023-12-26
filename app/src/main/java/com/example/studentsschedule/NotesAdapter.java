package com.example.studentsschedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesAdapter extends BaseAdapter {
    public List<Task> mTaskList;
    private Context mContext;

    public NotesAdapter(Context context, List<Task> taskList) {
        mContext = context;
        mTaskList = taskList;
    }

    @Override
    public int getCount() {
        return mTaskList.size();
    }

    @Override
    public Object getItem(int position) {
        return mTaskList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.notes_list, parent, false);
        }

        Task task = mTaskList.get(position);

        TextView noteNumberTextView = convertView.findViewById(R.id.note_number_edit_text);
        noteNumberTextView.setText(String.valueOf(task.getId()));

        TextView subjectTextView = convertView.findViewById(R.id.subject_edit_text);
        subjectTextView.setText(task.getSubject());

        TextView descriptionTextView = convertView.findViewById(R.id.note_edit_text);
        descriptionTextView.setText(task.getNote());

        return convertView;
    }
}
