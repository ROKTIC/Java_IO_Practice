package com.ezen.io.filterstream;

import java.io.*;

public class DataOutputStreamExample {

    public static void main(String[] args) throws IOException {
//        자바 기본타입별(8개)로 쓰기
        boolean flag = true;
        int password = 1234;
        long balance = 100000L;
        double rate = 0.35;
        String owner = "김기정";

        String path = "accounts.dbf";

//        OutputStream outputStream = new FileOutputStream(path);
        DataOutputStream out = new DataOutputStream(new FileOutputStream(path));
        out.writeBoolean(flag);
        out.writeInt(password);
        out.writeLong(balance);
        out.writeDouble(rate);
        out.writeUTF(owner);   // 인코딩 메소드( utf-8 )
        out.close();
        System.out.println("파일의 계좌정보 저장 완료");

    }
}
