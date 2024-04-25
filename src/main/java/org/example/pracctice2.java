package org.example;

import org.openqa.selenium.support.ui.ExpectedConditions;

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
        String s1 = "abc";
        String s2 = s1;
        String s3 = new String("abc");
        System.out.println(s1==s2);
        System.out.println(s2==s3);
        String s4 = s1.concat(s2);
        StringJoiner j1 = new StringJoiner("|","[","]");

        System.out.println(j1.add(s1).add(s2));
    }

    /**
     * This is a swap program without using other variable
     */
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

    /**
     * <p>This ia function
     * This returns a hashmap with name as key and age as value(@Link HashMap)
     * <i> Use where needed</i></p>
     * @param age - integer value
     * @param name - string value
     *
     * @return HashMap name:age
     *
     * @see HashMap
     */
    public static HashMap<String,Integer> foo(int age,String name){
         HashMap<String,Integer> retval = new HashMap<>();
         retval.put(name,age);
         return retval;
    }


}
