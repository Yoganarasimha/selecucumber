package org.example;

import java.util.Arrays;
import java.util.List;

public class counter {
    public static void main(String[] args) {
        String test = "";
        
    }
    static void count(String s){
        int wordCount = 0;
        int vowels = 0;
        int consonants = 0;
        int spchars = 0;
        List<Character> vowel = Arrays.asList('a','e','i','o','u','A','E','O','U','I');
        for(Character c: s.toCharArray()){
            if(c==' ') wordCount++;
            else if ((c<='z'&&c>='a')||(c<='Z'&&c>='A')) {
                if(vowel.contains(c))vowels++;
                else consonants++;
            }else spchars++;
        }
        System.out.println("vowels :"+vowels);
        System.out.println("consonants: ");
    }
}
