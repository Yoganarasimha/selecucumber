package org.example;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {
    String str = "Today is a good day"; // "yaddo og a siya doT"

    public static void main(String[] args) {
        String s1 = "Java is a ProgrAmming Language";
        System.out.println(s1.replaceAll("[^aeiouAEIOU]","").length());
        int cnt = 0;
        for(int n=0;n<s1.length();n++){
            if (String.valueOf(s1.charAt(n)).equalsIgnoreCase("a") || String.valueOf(s1.charAt(n)).equalsIgnoreCase("e") || String.valueOf(s1.charAt(n)).equalsIgnoreCase("i") || String.valueOf(s1.charAt(n)).equalsIgnoreCase("o") || String.valueOf(s1.charAt(n)).equalsIgnoreCase("u")) {
                cnt++;
            }
        }
        System.out.println(cnt);

        System.out.println(capitalizeString(s1));

        Integer[] years = {1996,2000,1800,1900,1904,1984,1995,2000,2020,2022,2024};
        List<Integer> yrs = Arrays.stream(years).filter(x->(x%4==0&&x%100!=0)||x%400==0).collect(Collectors.toList());
        System.out.println(yrs);

        prc5();
        String[] words = "hello you are a good boy".split(" ");
        Iterator<String> its = Arrays.stream(words).iterator();
        Optional<String> o = Optional.of("hello");
        int[] fibs = {0,1};
        Stream<Integer> fib = Stream.generate(()->{
            int result = fibs[1];
            int fib3 = fibs[0]+fibs[1];
            fibs[0] = fibs[1];
            fibs[1] = fib3;
            return result;
        });
        fib.limit(10).collect(Collectors.toList()).forEach(System.out::println);

        Stream<Integer> primes = Stream.generate(new PrimeSupplier())
                .filter(prime -> prime<= 100)
                .limit(10);
        primes.forEach(System.out::println);
    }


    static class PrimeSupplier implements Supplier<Integer> {
        private int current = 1;
        public Integer get(){
            current++;
            while(!isPrime(current)){
                current++;
            }
            return current;
        }

        public boolean isPrime(int num){
            if(num<=1){
                return false;
            }
            for(int i=2;i<=Math.sqrt(num);i++){
                if(num%i==0) return false;
            }
            return true;
        }
    }

    public static String capitalizeString(String s){
        final String ACTIONABLE_DELIMITERS = " '-/";
        StringBuilder sb = new StringBuilder();
        boolean cpNext = true;
        for(char c: s.toCharArray()){
            c = (cpNext)
                    ? Character.toUpperCase(c)
                    : Character.toLowerCase(c);
            sb.append(c);
            cpNext = (ACTIONABLE_DELIMITERS.indexOf(c)>=0);
        }
        return sb.toString();
    }

    public static void prc5(){
        List<String> lst = new ArrayList<>(List.of(new String[]{"area", "aria", "jenga", "mob", "ra", "hexagon"}));
        lst.stream().sorted((o1,o2)->new comp().compare(o1,o2)).forEach(System.out::println);
    }
    public static void prc4(){
        String str = "Clou#$$d Tech";
        String non_special = "";
        String special = "";
        for(char c: str.toCharArray()){
            if(Character.isAlphabetic(c)||Character.isDigit(c)) non_special +=String.valueOf(c);
            else special += String.valueOf(c);
        }
        System.out.println("Special characters: "+ special + "\t count = "+special.length());
        System.out.println("non special characters "+non_special+"\tcount = "+non_special.length());
    }

    public static void prc3(){
        String str = "Good Morning";
        String res = "";
        for(char c: str.toCharArray()) res += String.valueOf(toggleCase(c));
        System.out.println(res);
    }
    public static Character toggleCase(Character a){
        if(Character.isAlphabetic(a)){
            if(Character.isUpperCase(a)) return String.valueOf(a).toLowerCase().charAt(0);
            else return String.valueOf(a).toUpperCase().charAt(0);
        }else return a;

    }

    public static void prc2(){
        /*
        ***** String str = "java is cOOl"
    WAP to convert above String to:
	all to uppercase,
	all to lowercase,
	First character of String to uppercase and rest to lowercase,
	First character of each word to uppercase and rest of the characters in each String to lowercase

         */
        String str = "java is cOOl";
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
        System.out.println("first letter of sentence to upper and rest to lower");
        StringBuffer buf = new StringBuffer();
        for(int i=0;i<str.length();i++){
            Character c = str.charAt(i);
            if(i==0){
                buf.append(String.valueOf(str.charAt(i)).toUpperCase());
            }else{
                buf.append(String.valueOf(str.charAt(i)).toLowerCase());
            }
        }
        System.out.println(buf.toString());
        System.out.println("first letter of each word to capital and rest in lower case");
        String[] words = str.split(" ");
        String[] new_words = new String[words.length];
        for(int k=0;k<words.length;k++){
            String word = words[k];
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<word.length();j++){
                if(j==0)sb.append(String.valueOf(word.charAt(j)).toUpperCase());
                else sb.append(String.valueOf(word.charAt(j)).toLowerCase());
            }
            new_words[k] = sb.toString();
        }
        System.out.println(String.join(" ",new_words));

    }



    public static void prc1(){
        String str = "Today is a good day"; // "yaddo og a siya doT"
        List<Integer> spaces = new ArrayList<>();
        /*for(char c: str.toCharArray()){
            if(c == ' '){
                System.out.println("index of current character = "+str.indexOf(c));
                spaces.add(str.indexOf(c));
            }
        }*/
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ') spaces.add(i);
        }
        System.out.println(spaces);
        StringBuilder sb1 = new StringBuilder(str);
        String s = str.replaceAll(" ","");
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        for(Integer i: spaces){
            System.out.println("index value is: "+i.intValue());
            sb.insert((int)i,' ');
        }
        System.out.println(sb.toString());

        /*List<String> strs = new ArrayList<>();
        strs.add("eng");
        strs.add("tam");
        strs.add("kan");
        strs.add("mal");
        List<String> rem = Arrays.asList("eng","kan");
        for(String s: rem){
            strs.remove(strs.indexOf(s));
        }
        System.out.println(strs);*/
    }

    static class comp implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }

        @Override
        public Comparator<String> reversed() {
            return Comparator.super.reversed();
        }
    }


}
