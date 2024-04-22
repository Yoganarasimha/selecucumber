package org.example;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class pracctice2 {
    public static void main(String[] args) {
        /*Integer[] nums = {1,2,3,4,5,23,21,43,57,65,89,87,83,43,52,31};
        System.out.println("even numbers in list");
        System.out.println(Arrays.stream(nums).filter(x->x%2==0).collect(Collectors.toList()));
        System.out.println("odd numbers in list");
        System.out.println(Arrays.stream(nums).filter(x->x%2!=0).collect(Collectors.toList()));
        IntPredicate isPrime = n-> n>1 && IntStream.range(2,(int)Math.sqrt(n)+1).noneMatch(i->n%i==0);
        System.out.println("primes in list");
        System.out.println(Arrays.stream(nums).filter(isPrime::test).collect(Collectors.toList()));
        System.out.println("non primes in list");
        System.out.println(Arrays.stream(nums).filter(x->!isPrime.test(x)).collect(Collectors.toList()));
        swap();
        prc4();*/
        itex();
    }

    public static void swap(){
        int a=100,b=500;
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println("after swap "+a+" "+b);
    }

    public static void prc4(){
        String a = "ABCD";
        String b = "DABC";
        for(int i=1;i<a.length();i++){
            String c = rotateonce(a);
            System.out.println(c);
            if(c.equals(b)){
                System.out.println("b is rotation of a");
                break;
            }else a=c;
            System.out.println("rotation count: "+i);
        }
    }
    public static String rotateonce(String s){
        Map<String,Integer> m = new HashMap<>();
        return s.substring(1)+s.substring(0,1);
    }

    public static class cons implements Consumer<Integer>{


        public void accept(Integer integer) {
            System.out.println(integer);
        }
    }

    public static void itex(){
        List<Integer> ints = new ArrayList<>();
        for(int i=1;i<=10;i++){
            ints.add(i);
        }
        Iterator<Integer> it = ints.iterator();
        while(it.hasNext()){
            int current = it.next();
            it.forEachRemaining(System.out::println);
        }
    }





}
