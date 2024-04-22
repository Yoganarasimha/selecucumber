package org.example;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void print(){
        String m = this.name+"\t"+this.age+"\t"+this.gender;
        System.out.println(m);
    }
}

public class Avg {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30, "Female"),
                new Person("Bob", 25, "Male"),
                new Person("Charlie", 35, "Male"),
                new Person("Diana", 28, "Female"),
                new Person("Eve", 40, "Female")
        );
        people.stream().sorted((p1,p2)->p2.getAge()-p1.getAge()).limit(3).forEach(Person::print);
        Map<String,Double> avgs = people.stream().collect(
                Collectors.groupingBy(
                        Person::getGender,
                        Collectors.averagingInt(Person::getAge)
                )
        );
        System.out.println(avgs);
        String a = "hello World";
        Set<Character> charset;
        char[] chars = a.toCharArray();
        

    }
}

