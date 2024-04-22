package org.example;

public class student {
    private int age;
    private String name;
    private String school;
    private double score;

    public student(String name, String school, int age, double score){
        this.age = age;
        this.name = name;
        this.school = school;
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }

    public double getScore() {
        return score;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
