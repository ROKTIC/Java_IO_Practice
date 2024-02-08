package com.ezen.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamExample2 {
    public static void main(String[] args) throws IOException {

        String path = "/Applications/StarCraft II/Interfaces/Pro_2020.SC2Interface";
        InputStream in = new FileInputStream(path);

        // 파일의 모든 바이트를 바이트 배열 단위로 읽기
        byte[] buffer = new byte[4*1024];  // 4 ~ 6KB가 효율적인 배열 사이즈
        int byteCount = 0;
        int totalSize = 0;
        while ((byteCount = in.read(buffer)) != -1) {
            totalSize += byteCount;
        }

        System.out.println("총 "+ totalSize/1024 +" KB 입력완료");
        in.close();
    }
}
