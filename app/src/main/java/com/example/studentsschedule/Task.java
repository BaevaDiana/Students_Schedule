package com.example.studentsschedule;

public class Task {
    private int mId;
    private String mSubject;
    private String mNote;

    public Task() {
    }

    public Task(int id, String subject, String note) {
        mId = id;
        mSubject = subject;
        mNote = note;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getSubject() {
        return mSubject;
    }

    public void setSubject(String subject) {
        mSubject = subject;
    }

    public String getNote() {
        return mNote;
    }

    public void setNote(String note) {
        mNote = note;
    }
}
