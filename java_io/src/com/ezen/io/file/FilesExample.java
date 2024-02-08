package com.ezen.io.file;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

//  파일이나 디렉토리 관련 유용한 정적 메소드를 제공하는 유틸 클래스
public class FilesExample {

    public static void main(String[] args) throws IOException {

        String data = "id : winter\n" +
                "email : winter@mycompany.com\n" +
                "tel : 010-1234-5678";

        Path path = Paths.get("/Applications/Temp/user.txt");
        Files.writeString(path, data, Charset.forName("utf-8"));
        System.out.println("정보 저장 완료");

//        파일 유형
        String contentType = Files.probeContentType(path);
        System.out.println(contentType);         // 출력 결과 : text/plain < 일반적인 텍스트 >

//        파일 크기
        long filesize = Files.size(path);
        System.out.println(filesize);

//        파일 존재 여부
        boolean exists = Files.exists(path);
        System.out.println(exists);

//        디렉토리 생성
        Path directoryPath = Files.createDirectories(Paths.get("/Applications/aaa/bbb"));
        System.out.println(directoryPath);

//       파일 생성
     /*   Path newFIlePath = Files.createFile(Paths.get("Applications", "aaa", "bbb", "some.txt"));
        System.out.println(newFIlePath);*/

//        File 클래스에 존재하지 않는 기능들 ..

//        파일 복사
        Path srcPath = Paths.get("Applications", "Temp", "user.txt");
        Path destPath = Paths.get("Applications", "xxx", "copyfile3.txt");

//        파일 존재 시 예외 발생
//        Path copyPath = Files.copy(srcPath,destPath);

//        파일 존재 시 덮어쓰기
       /* Path copyPath = Files.copy(srcPath, destPath, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("복사된 파일 : " + copyPath);*/

//        파일 이동
     /*   Path movePath = Paths.get("Applications", "Temp", "file2.txt");
        Path movedPath = Files.move(srcPath, movePath, StandardCopyOption.REPLACE_EXISTING);
        System.out.println(movedPath);*/

        try {
            Path copiedPath = copyFile(srcPath, Paths.get("Applications", "xxx", "복사본.txt"));
            System.out.println(copiedPath + "에 복사 완료");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    //        Files 클래스를 이용한 파일 복사 기능
    public static Path copyFile(Path srcPath, Path destPath) {
        try {
            return Files.copy(srcPath, destPath);
        } catch (IOException e) {
            throw new RuntimeException("기존에 존재하는 파일입니다..");
        }
    }
}
