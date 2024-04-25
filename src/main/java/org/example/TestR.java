package org.example;

import java.util.Scanner;

public class TestR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        StringBuilder sb = new StringBuilder();
        StringBuilder rep = new StringBuilder();

        String result = "404";
        if(A.length()!=B.length()) result = "-1";
        for(int i=0;i<A.length();i++){
            char c = A.charAt(i);
            if(c=='%'){
                sb.append(B.charAt(i));
                rep.append(B.charAt(i));
            }else sb.append(c);
        }
        if(B.contentEquals(sb.toString())) result = rep.toString();
        else result = "-1";

        System.out.println(result);
    }
}
