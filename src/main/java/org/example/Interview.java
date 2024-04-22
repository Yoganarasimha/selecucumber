package org.example;

import org.apache.logging.log4j.util.PropertySource;

import java.util.*;
import java.util.stream.Collectors;

public class Interview {
    public static void main(String[] args) {

        String[] str = {"abc","bac","cab","bed","fed","def"};
        HashMap<String,Integer> results = new HashMap<>();

        String[] src = str;
        for(String s: src){
            char[] x = s.toCharArray();
            Arrays.sort(x);
            String c = new String(x);

            results.put(c,results.getOrDefault(c,0)+1);
        }

        System.out.println(results);


        String d = "asowoenvoeirnv984ghoienvoienvu4gh98gjeeidfnv";
        Arrays.asList(d.toCharArray()).stream().collect(Collectors.toSet()).forEach(System.out::println);
        HashMap<String,Integer> m = new HashMap<>();
        for(char c: d.toCharArray()){
            m.put(String.valueOf(c),m.getOrDefault(String.valueOf(c),0)+1);
        }
        System.out.println(m);



    }
}
