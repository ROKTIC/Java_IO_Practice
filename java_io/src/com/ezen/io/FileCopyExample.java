package com.ezen.io;

import java.io.*;

public class FileCopyExample {

    public static synchronized long fileCopy(String srcPath, String destPath) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        long copySize = 0L;

        try {
            in = new FileInputStream(srcPath);
            out = new FileOutputStream(destPath);

            byte[] buffer = new byte[4 * 1024];
            int byteCount = 0;
            copySize = in.available();

            while ((byteCount = in.read(buffer)) != -1) {
//                out.write(buffer); // 오버해서 복사됨 ..
                out.write(buffer, 0 ,byteCount); // ex) 4kb , 4kb, ....., 20kb..
            }
        } finally {
            in.close();
            out.close();
        }
        return copySize;
    }

    public static void main(String[] args) throws IOException {

        System.out.println("프로그램 시작됨...");

        //        파일 복사는 사용자 스레드로 실행
        Thread copyThread = new Thread() {
            @Override
            public void run() {
                long copySize = 0;
                try {
                    copySize = fileCopy("/Applications/StarCraft II/Interfaces/Pro_2020.SC2Interface",
                            "SC2.exe");
                } catch (IOException e) {
                    System.err.println("파일 복사 중 오류가 발생하였습니다. \n 다시 한번 시도해주세요.");
                }
                System.out.println("파일 복사 완료 : " + copySize);
            }
        };
        copyThread.start();
        System.out.println("프로그램 종료됨...");
    }
}
