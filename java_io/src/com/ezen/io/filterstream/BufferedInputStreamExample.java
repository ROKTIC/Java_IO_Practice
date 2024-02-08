package com.ezen.io.filterstream;

import java.io.*;

public class BufferedInputStreamExample {

    public static void main(String[] args) throws IOException {
        String path = "/Applications/StarCraft II/Interfaces/Pro_2020.SC2Interface";
        //        Node Stream 생성
        InputStream is = new FileInputStream(path);

//              Filter Stream 생성
//              Filter Stream 은 인자로 반드시 Node Stream 을 받아야한다.
        BufferedInputStream in = new BufferedInputStream(is); //  매개변수로 inputStream 형식

  /*      int data = 0;
        while ((data = in.read()) != -1) {
//            디스크에서 한 번에 512 바이트 읽음
//            내부 버퍼에서 1바이트 읽음
//            System.out.println(data);
        }
        System.out.println("파일 읽기 완료 ...");*/

//        추가된 조작기능 ( mark(),reset(),skip() )
        in.mark(0);
        System.out.println("첫번째 바이트 : " + in.read());
        System.out.println(in.read());
        System.out.println(in.read());

        in.skip(1); // 1바이트 스킵
        in.skip(1);
        in.skip(5);
        System.out.println(in.read());
//        백도어
        in.reset();
        System.out.println("첫번째 바이트 : " + in.read());
        in.close();

        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("example2.dat"));
        out.write(10); // 메모리 버퍼에 1바이트 출력
        out.write(10); // 메모리 버퍼에 1바이트 출력
        out.write(10); // 메모리 버퍼에 1바이트 출력
        out.write(10); // 메모리 버퍼에 1바이트 출력

        // 버퍼에 저장된 데이터 출력 ( 꽉 차지 않아도 출력 - flush() )
        out.flush();

    }
}
