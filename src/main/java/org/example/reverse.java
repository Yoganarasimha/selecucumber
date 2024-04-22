package org.example;

import java.util.HashMap;

public class reverse {
    static HashMap<Integer,Integer> table = new HashMap<>();
    public static void main(String[] args) {
        for(int i=0;i<=5;i++){
            System.out.println(fib(i));
        }
    }

    public static String revstr(String s){
        if(s==null||s.length()<=1){
            return s;
        }
        return revstr(s.substring(1))+s.charAt(0);
    }

    public static int fib(int count){
        if(count==0){
            return 0;
        } else if (count==1||count==2) {
            return 1;
        }else{
            int result;
            if(table.containsKey(count)) result = table.get(count);
            else result = fib(count-1)+fib(count-2);
            table.put(count,result);
            return result;
        }
    }
}
