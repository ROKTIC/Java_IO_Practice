package com.ezen.io.diary;

public class DiaryApp {
    public static void main(String[] args) {
        Diary diary = new Diary();
        diary.init();
        diary.setSize(700, 500);
        diary.addEventListener();
        diary.setVisible(true);
    }
}
