package com.ezen.io.bridge;

import java.io.*;
import java.util.stream.Stream;

public class BridgeStreamExample {
    public static void main(String[] args) throws IOException {
        System.out.print("이름 : ");
//        InputStreamReader isr = new InputStreamReader(System.in);
//        BufferedReader br = new BufferedReader(isr);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        System.out.println(name);
        br.close();

        String path = "/Applications/Temp/샘플.txt";
        InputStream inputStream = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(inputStream, "utf-8");
        BufferedReader in = new BufferedReader(isr);
        String txt = null;
        while ((txt= in.readLine()) != null) {
            System.out.println(txt);
        }
        in.close();
        isr.close();
    }
}
