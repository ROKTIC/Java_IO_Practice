package com.ezen.io.character;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

// 문자 출력 스트림 예제
public class WriterExample {

    public static void main(String[] args) throws IOException {
        String path = "sample.txt";
        Writer writer = new FileWriter(path,true); // append true => 덮어쓰지 않고 이어붙히기

      /*  Character ch1 = '김';
        Character ch2 = '기';
        Character ch3 = '정';

        writer.write(ch1); // 문자 단위 출력 (인코딩 기능도 있음)
        writer.write(ch2); // 문자 단위 출력 (인코딩 기능도 있음)
        writer.write(ch3); // 문자 단위 출력 (인코딩 기능도 있음)*/

        /*char[] chars = {'김','찬','규'};
        writer.write(chars);
        writer.write(chars, 0, 2); */

        String message = "문자 스트림";
        writer.write(message);

        writer.close();

    }
}
