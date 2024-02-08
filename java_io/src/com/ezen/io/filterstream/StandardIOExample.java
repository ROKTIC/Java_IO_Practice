package com.ezen.io.filterstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 표준 입출력
 * 표준 입력 : 키보드에서 입력
 * 표준 출력 : 모니터(콘솔)에 출력
 */
public class StandardIOExample {
    public static void main(String[] args) throws IOException {
        // System 클래스에 만들어져 있는 PrintStream 사용
       /* System.out.print();
        System.out.println();
        System.out.printf();*/

//        int age = 20;
//        System.out.println(age);  // 정수를 문자열로 형변환 후 출력

//        표준 입력 ( BufferedInputStream )
//        System.out.println(System.in);
//        System.out.println("키보드에서 아무 키나 입력하세요 : ");
//        int data = System.in.read();
//        System.out.println((char)data); // 문자코드 디코딩 처리

//        byte[] buffer = new byte[100];
//        int byteCount = System.in.read(buffer);
//        System.out.println(byteCount);
//        String input = new String(buffer, 0, byteCount - 1); // 문자 디코딩
//        System.out.println(input);
//
//        byte[] ageBuffer = new byte[3];
//        System.out.print("나이를 입력하세요 : ");
//        byteCount = System.in.read(ageBuffer);
//        String stringAge = new String(ageBuffer, 0, byteCount - 1);
//        int age2 = Integer.parseInt(stringAge);
//
//        System.out.println(age2);

        // java 5 버전에 Scanner 유틸리티 지원
      /*  Scanner scanner = new Scanner(System.in);
        System.out.print("이름 : ");
        String name = scanner.nextLine();
        System.out.println(name);

        System.out.println("몸무게 : ");
        double weight = scanner.nextDouble();
        System.out.println(weight);*/

        Scanner scanner = new Scanner(new FileInputStream("accounts.dat"));
        String txt = scanner.nextLine();
        System.out.println(txt);


    }
}