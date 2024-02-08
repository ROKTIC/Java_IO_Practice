package com.ezen.io.objectstream;

import com.ezen.io.character.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectOutputStreamExample {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("10", "김기정", 30, 95.5);

//        바이트 스트림으로 파일에 저장하기
        String path1 = "byte_student.dat";
        OutputStream outputStream = new FileOutputStream(path1);
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF(student.getSsn());
        dataOutputStream.writeUTF(student.getName());
        dataOutputStream.writeInt(student.getAge());
        dataOutputStream.writeDouble(student.getAverage());

        dataOutputStream.close();
        System.out.println("파일에 학생 정보 저장");

//        문자 스트림으로 학생 정보 저장
        String path2 = "character_student.dat";
        PrintWriter printWriter = new PrintWriter(path2);
        printWriter.println(student.getSsn() + "," + student.getName() + "," + student.getAge() + "," + student.getAverage());
        printWriter.close();
        System.out.println("파일에 학생 정보 저장");

//        ObjectStream 으로 학생 정보 저장
        String path3 = "object_student.ser";  // 바이트 스트림으로 저장해서 글자는 제대로 안보임
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path3));  // 바이트 스트림의 일종
//        oos.writeObject(student); // 객체 직렬화( 마샬링 ) , 객체의 필드값을 연속적인 바이트 값으로 파일에 저장
        List<Student> list = new ArrayList<>();
        list.add(new Student("111", "가나다", 30, 50));
        list.add(new Student("222", "가나다", 30, 50));
        list.add(new Student("333", "가나다", 30, 50));
        list.add(new Student("444", "가나다", 30, 50));
        oos.writeObject(list);

        System.out.println("파일에 학생 목록 저장 완료..");
//        System.out.println("파일에 학생 객체 저장 완료..");
        oos.close();

//        파일에서 객체 읽어오기
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path3));
//        Student readStudent = (Student) ois.readObject();  // 역직렬화( 언마샬링 ) / (Student) 로 다운 캐스팅
        List<Student> readStudents = (List<Student>) ois.readObject();
        for (Student readStudent : readStudents) {
            System.out.println(readStudent);
        }
        ois.close();
    }
}
