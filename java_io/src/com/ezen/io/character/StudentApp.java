package com.ezen.io.character;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StudentApp {

    public static void main(String[] args) throws IOException {
        /*System.out.println("-- 우리반 학생 목록 --");
        System.out.println("학번  이름  나이  평균 ");
//        콘솔창에  학생  목록  출력
//  ex)  학번   이름   나이   평균

        String path = "src/resource/학생목록.dat";
        FileReader fileReader = new FileReader(path);

        int ch;
        while((ch = fileReader.read()) != -1){
            if((char)ch == ','){
                System.out.print("  ");
            }
            if((char)ch != ',') {
                System.out.print((char)ch);
            }
        }
        fileReader.close();*/

        ///////////////////////////////////////////////////////////////////////////

        String filePath = "src/resource/학생목록.dat";
        Path path = Paths.get(filePath);
        boolean exists = Files.exists(path);
        if(!exists){
            Files.createFile(path);
        }
        if (Files.size(path) == 0){
            System.out.println("등록된 학생 정보가 없습니다.");
            return;
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        System.out.println("학번   이름   나이   평균");
        String row = null;
        while ((row = bufferedReader.readLine()) != null){
            Student student = convertStudentInfo(row);
//            System.out.println(student);
            System.out.println(student.getSsn() + "\t" + student.getName() + "\t" + student.getAge() + "\t" + student.getAverage());
        }

    }
    public static Student convertStudentInfo(String row){
        Student student = new Student();
        String[] tokens = row.split(",");
        student.setSsn(tokens[0]);
        student.setName(tokens[1]);
        student.setAge(Integer.parseInt(tokens[2]));
        student.setAverage(Double.parseDouble(tokens[3]));

        return student;
    }
}
