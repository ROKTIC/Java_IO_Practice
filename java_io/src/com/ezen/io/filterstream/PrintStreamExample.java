package com.ezen.io.filterstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Calendar;

public class PrintStreamExample {
    public static void main(String[] args) throws FileNotFoundException {

        boolean flag = true;
        int password = 1234;
        long balance = 100000L;
        double rate = 0.35;
        String owner = "김기정";
        String path = "accounts.dat";

//        모든 자바 데이터 타입을 문자열로 형변환 후 문자열 저장
        PrintStream ps = new PrintStream(new FileOutputStream(path)); // 필터스트림이라 노드 지정해줘야 함
        ps.println(flag); // 문자열 "true" 로 바뀌어서 출력된다.
        ps.println(password); // 문자열 "1234"
        ps.println(balance); // 문자열 "1000000"
        ps.println(rate); // 문자열 "0.35"
        ps.println(owner); // 문자열 "김기정"

        ps.printf("%1$tF %1$tT %1$tA", Calendar.getInstance());
        ps.close();
        System.out.println("출력 완료");
    }
}
