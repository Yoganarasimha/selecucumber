package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.util.PropertySource;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       /* List<Integer> src = new ArrayList<Integer>();
        Random r = new Random();
        for(int i = 0;i<=100;i++){
            int x = r.nextInt(100);
            src.add(x);
        }

        List<Integer> sortsrc = src.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortsrc);

        System.out.println(src.stream().mapToInt(Integer::intValue).max());
        System.out.println(src.stream().mapToInt(Integer::intValue).min());
        System.out.println(src.stream().mapToInt(Integer::intValue).average());*/

        /*List<String> names = new ArrayList<>();
        names.add("Zebra");
        names.add("apple");
        names.add("Bali");
        names.add("Costa");
        names.add("Catalina");
        names.add("delphi");
        names.add("Dalma");

        names.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        names.stream().sorted(Comparator.reverseOrder()).filter(s->s.length()>4).forEach(System.out::println);*/

        List<student> cls = new ArrayList<>();
        cls.add(new student("jatin","jenga",8, 4.0));
        cls.add(new student("geeta","jenga",18, 3.4));
        cls.add(new student("jati","kongo",17, 3.3));
        cls.add(new student("varun","kongo",21,2.3));

        List<student> lst = cls.stream()
                .sorted((s1,s2)->s1.getName().compareToIgnoreCase(s2.getName()))
                .filter(s->s.getSchool().equalsIgnoreCase("kongo")).collect(Collectors.toList());
        for(student s: lst){
            System.out.println(s.getName()+"\t"+s.getAge());
        }
    }

    static class StringComparaator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return - o1.compareTo(o2);
        }
    }
}
