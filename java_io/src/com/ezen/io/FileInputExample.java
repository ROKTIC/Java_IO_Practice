package com.ezen.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputExample {

    public static void main(String[] args) {
        String filePath = "example.dat";
        InputStream inputStream = null;

//        파일에서 읽어들인 바이트들을 저장하기 위한 빈배열 생성
        byte[] buffer = new byte[3];

        try {
            inputStream = new FileInputStream(filePath);
//            int data1 = inputStream.read();
//            int data2 = inputStream.read();
//            int data3 = inputStream.read();
//            System.out.println("읽은 바이트 : " + data1);
//            System.out.println("읽은 바이트 : " + data2);
//            System.out.println("읽은 바이트 : " + data3);

//            배열 단위로 읽기 ( 효율적 )
//            읽어들인 바이트 수 반환
            int byteCount = inputStream.read(buffer); // 읽어들인 바이트 수
            System.out.println("파일로부터 읽어들인 바이트 수 : " + byteCount);
            for (byte data : buffer) {
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.err.println("읽고자 하는 파일이 존재하지 않습니다.");
        } catch (IOException e) {
            System.err.println("파일 읽기 중 오류가 발생하였습니다.");
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }

    }
}
