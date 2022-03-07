package com.tom.lib.java;

class Student {
    String name;
    int english;
    int math;
    public Student() {
        this("", 0, 0);
    }
    public Student(String name, int english, int math) {
        this.name = name;
        this.english = english;
        this.math = math;
    }
    public char getGrade() {
        int avg = getAverage()/10;
        char grade = 'F';
        switch(avg) {
            case 10:
            case 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6:
                grade = 'D';
                break;
        }
        return grade;
    }
    public int getAverage() {
        return (english+math)/2;
    }
    public void print() {
        System.out.println(name + "\t" + english + "\t" + math);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }
    public int max(int a , int b) {
        return 0;
    }
}
