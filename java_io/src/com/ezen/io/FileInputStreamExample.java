package com.ezen.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamExample {
    public static void main(String[] args) throws IOException {

        String path = "/Applications/StarCraft II/Interfaces/Pro_2020.SC2Interface";
        InputStream in = new FileInputStream(path);

        // 파일의 모든 바이트 데이터 읽기
        while (true) {
           int data = in.read();
           if(data == -1){ // 파일의 끝
               break;
           }
//            System.out.print(data);
        }
        System.out.println("입력완료 ! ");
        in.close();
    }
}
