package com.ezen.io.character;

import java.io.*;

// 문자 입력 스트림 예제
public class ReaderExample {

    public static void main(String[] args) throws IOException, InterruptedException {
        String path = "sample.txt";
        Reader reader = new FileReader(path);
//        int ch = reader.read();
//        System.out.println((char)ch);

    /*    int ch = 0;
        while ((ch = reader.read()) != -1) {
//            Thread.sleep(500);
            System.out.print((char)ch);
        }*/

       /* char[] buffer = new char[10];
        int readCount = 0;
        while ((readCount=reader.read(buffer)) != -1) {
//            String 생성자를 이용한 디코딩
            String message = new String(buffer, 0, readCount);
            System.out.print(message);
        }*/

        File file = new File(path);
        long fileSize = file.length();
        int count = (int)(fileSize/2);

        char[] buffer = new char[count];
        reader.read(buffer);
        String txt = new String(buffer);
        System.out.println(txt);

        reader.close();
    }
}
