package com.ezen.io.file;

import java.io.File;
import java.io.IOException;

public class FileExample2 {

    public static void makeDirectory(String directoryName) {
        File file = new File(directoryName);

        if (!file.exists()) {
            file.mkdirs();
        } else {
            throw new RuntimeException("이미 디렉토리가 존재합니다."); // 간단하게 그냥 RuntimeException
        }
    }

    public static void main(String[] args) throws IOException {
//            String path = "/Applications/xxx/yyy";
        String path = "/Applications/xxx/zzz";
        try {
            makeDirectory(path);
            System.out.println("디렉토리 생성 완료");
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        File dir = new File("/Applications/Temp/images");
        File file1 = new File("/Applications/Temp/file1.txt");
        File file2 = new File("/Applications/Temp/file2.txt");
        File file3 = new File("/Applications/Temp/file3.txt");

//            존재하지 않을 경우 디렉토리 또는 파일 생성
        if (!dir.exists()) {
            dir.mkdirs();
        }
        if (!file1.exists()) {
            file1.createNewFile();
        }
        if (!file2.exists()) {
            file2.createNewFile();
        }
        if (!file3.exists()) {
            file3.createNewFile();
        }

//            /Applications/Temp 디렉토리의 목록 출력
        File tempDir = new File("/Applications/Temp");
        File[] contents = tempDir.listFiles();
        for (File content : contents) {
            if (content.isDirectory()) {
                System.out.println("<DIR> " + content.getName()); // 디렉토리
            } else {
//                    System.out.println(content.length() + " " + content.getName()); // 파일 이름
//                    System.out.println(content.length() + " " + content.getAbsolutePath()); // 파일의 절대 경로
                System.out.println(content.length() + " " + content.getParent()); // 파일을 가지고 있는 부모 경로
            }
        }

//        삭제
        File deleteFile = new File("/Applications/Temp/file1.txt"); // 폴더 안에 파일이 있으면 폴더 삭제 안된다.
        boolean deleted = deleteFile.delete();
        if(deleted) System.out.println("삭제 완료");
        else System.out.println("삭제 실패");

    } // main end
}
