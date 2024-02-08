package com.ezen.io.character;

import java.io.*;
import java.util.Calendar;

//
public class PrintWriterExample {

    public static void main(String[] args) throws IOException {
        String path = "sample3.txt";
//        PrintWriter printWriter = new PrintWriter(path);
//        PrintWriter printWriter = new PrintWriter(new FileOutputStream(path));
//        PrintWriter printWriter = new PrintWriter(new FileWriter(path));
        PrintWriter printWriter = new PrintWriter(new File(path));
        printWriter.print("바보");
        printWriter.println("바보2");
        int age = 30;
        printWriter.printf("%-+10d", age);
        printWriter.printf("%1$tF %1$tT", Calendar.getInstance());

        printWriter.close();
    }
}
