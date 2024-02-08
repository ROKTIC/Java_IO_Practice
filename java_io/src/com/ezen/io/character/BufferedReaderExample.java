package com.ezen.io.character;

import java.io.*;

// 내부 버퍼를 이용한 효율적 읽기 및 readLine() 메소드 제공
public class BufferedReaderExample {

    public static void main(String[] args) throws IOException {
        String path = "src/com/ezen/io/character/PrintWriterExample.java";

        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        String lineText = bufferedReader.readLine(); // \n은 제외
//        System.out.println(lineText);
        String lineText = null;
        int lineNumber = 0;
        while ((lineText = bufferedReader.readLine()) != null) {    // 더 이상 읽을 것이 없으면 null 리턴
            System.out.println(++lineNumber + " : " + lineText);

        }
        bufferedReader.close();
    }
}
