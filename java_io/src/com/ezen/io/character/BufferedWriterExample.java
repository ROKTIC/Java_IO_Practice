package com.ezen.io.character;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

// 문자 출력 스트림 예제
public class BufferedWriterExample {

    public static void main(String[] args) throws IOException {
        String path = "sample3.txt";
        Writer writer = new FileWriter(path,true); // append true => 덮어쓰지 않고 이어붙히기
        BufferedWriter bufferedWriter = new BufferedWriter(writer); // 필터의 일종이라 노드 스트림(writer) 필요

        String message = "문자 스트림";
        bufferedWriter.write(message);
        bufferedWriter.newLine(); // \n 기능
        bufferedWriter.write("다음 줄 체크");
        bufferedWriter.flush();

        writer.close();

    }
}
