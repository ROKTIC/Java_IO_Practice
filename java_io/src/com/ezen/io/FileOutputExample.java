package com.ezen.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 스트림 API 를 이용한 파일에 데이터 출력
 */
public class FileOutputExample {

    public static void main(String[] args) {
//        절대 경로
//        String filePath = "Application/xxxx/yyyy/example.dat"

//        상대 경로
        String filePath = "example.dat";
        byte data1 = 10, data2 = 20, data3 = 30;
        byte[] datas = {10,20,30};
        OutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(filePath, true);  // append: true 는 파일을 덮어쓰는 게 아니라 파일 뒤에 계속 이어 붙히는 것
//            outputStream.write(data1);
//            outputStream.write(data2);
//            outputStream.write(data3);

//            바이트 배열 단위로 출력 ( 효율적 )
            outputStream.write(datas);


            System.out.println("파일의 데이터 출력 완료! ! ");
//            outputStream.close(); // 스트림 닫고 , 메모리에서 해제
        } catch (FileNotFoundException e) {
            System.err.println("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            System.err.println("파일 데이터 출력 중 오류 발생");
        } finally {
            try {
                outputStream.close(); // 스트림 닫고 , 메모리에서 해제
            } catch (IOException e) {
            } // close 에서 문제 생기면 보통 그냥 아무 것도 안하는..
        }
    }
}
