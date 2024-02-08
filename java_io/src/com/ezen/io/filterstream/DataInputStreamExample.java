package com.ezen.io.filterstream;

import java.io.*;

public class DataInputStreamExample {

    public static void main(String[] args) throws IOException {
//        자바 기본타입별(8개)로 읽기
        boolean flag = false;
        int password = 0;
        long balance = 0L;
        double rate = 0.0;
        String owner = null;

        String path = "accounts.dbf";

        DataInputStream in = new DataInputStream(new FileInputStream(path));
        flag = in.readBoolean();
        password = in.readInt();
        balance = in.readLong();
        rate = in.readDouble();
        owner = in.readUTF();   // 디코딩 메소드( utf-8 )

        System.out.println(flag);
        System.out.println(password);
        System.out.println(balance);
        System.out.println(rate);
        System.out.println(owner);
        in.close();
    }
}
