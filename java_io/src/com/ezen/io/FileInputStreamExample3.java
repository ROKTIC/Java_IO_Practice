package com.ezen.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamExample3 {
    public static void main(String[] args) throws IOException {

//        문자(텍스트) 파일 읽기
        String path = "./src/com/ezen/io/FileInputExample.java";
        InputStream in = new FileInputStream(path);
        int readableCount = in.available();
        System.out.println("파일 사이즈 : " + readableCount);

        byte[] buffer = new byte[200]; // 파일 용량이 작아서 200바이트로
        int byteCount = 0;
        while ((byteCount = in.read(buffer)) != -1) {

     /*       for (byte b : buffer) {
//                System.out.print(b);
//                문자 디코딩(문자 코드 -> 문자) 처리 후 출력

                System.out.print((char) b);
            }
            */

            //   String 생성자를 이용한 디코딩
//            String text = new String(buffer);
            String text = new String(buffer, 0, byteCount, "utf-8");
            System.out.println(text);
        }
//        System.out.println(in.available());
        in.close();
    }
}
