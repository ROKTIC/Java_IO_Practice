package com.ezen.io.file;

import java.io.File;
import java.net.URL;
import java.util.Calendar;
    
// File 클래스는 스트림 클래스 아님
public class FileExample {

    public static void main(String[] args) {
//        String path = "/Applications/xxxx.txt";
        String path = "accounts.dbf";

//        실제 파일 존재 여부를 확인
        File file = new File(path);
        boolean exist = file.exists();
        System.out.println("exist = " + exist);

        long fileSize = file.length();
        System.out.println("fileSize = " + fileSize);

        long modifierd = file.lastModified();
        System.out.println("modifierd = " + modifierd);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(modifierd);
        System.out.println(String.format("%1$tF %1$tT %1$tA", calendar));

//        프로젝트를 기준으로 현재 파일의 절대 경로
        String absolutePath = file.getAbsolutePath();
        System.out.println("absolutePath = " + absolutePath);

//        현재 클래스를 기준으로 파일의 절대경로
       /* Class cls = FileExample.class;
        URL url = cls.getResource("/resource/accounts.dbf");
        String path2 = url.getPath();
        System.out.println("path2 = " + path2);*/

        System.out.println(file.canRead());
        System.out.println(file.canWrite());

        String path3 = "/Applications/ezen-fullstack";
        File file3 = new File(path3);
        System.out.println(file3.isDirectory()); // true
        System.out.println(file3.isFile());     // false

//        현재 컴퓨터의 사용자 홈 디렉토리의 디렉토리 목록 출력
        String homeDirectoryPath = System.getProperty("user.home"); //   /Users/yunyun
        File homeDirectoryFile = new File(homeDirectoryPath); // 파일 객체 생성
        File[] subFiles = homeDirectoryFile.listFiles();
        for (File subFile : subFiles) {
            if(subFile.isDirectory()){
//             디렉토리인 경우
                System.out.println("<DIR> " + subFile.getName());
            }else {
//                파일인 경우
                System.out.println(subFile.length() + ", " + subFile.getName());
            }
        }
    }
}
