package com.ezen.io.character;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Student implements Serializable {  // 마킹 인터페이스

    @Serial
    private static final long serialVersionUID = 8551406628729192319L;

    private String ssn;
    private String name;
    private int age;
    private double average;
//    public transient int password = 1111;  // 직렬화 제외

    public String subject;

    public Student() {}
    public Student(String ssn, String name, int age, double average) {
        this.ssn = ssn;
        this.name = name;
        this.age = age;
        this.average = average;

    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ssn='" + ssn + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", average=" + average +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof Student)){
            return false;
        }
        return toString().equals(object.toString());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
