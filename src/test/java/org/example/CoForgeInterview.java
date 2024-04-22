package org.example;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoForgeInterview {
    public static void main(String[] args) throws ParseException {
        //q1alt();
        v2();
    }
    public void q1(){
        String inp = "Yogashankar";
        //expected output "rogashankaY"
        char last = inp.charAt(0);
        char first = inp.charAt(inp.length()-1);
        StringBuilder sb = new StringBuilder();
        sb.append(first);
        for(char c: inp.toCharArray()){
            if (inp.indexOf(c)==0 || inp.indexOf(c)==inp.length()-1){
                continue;
            }else{
                sb.append(c);
            }
        }
        sb.append(last);
        System.out.println(sb);
    }

    public static void q2(){
        String strData = "Name=Yogashankar|Loc=Pune|Pin=001";
        Map<String,String> output  = new HashMap<>();
        String[] data = strData.split("\\|");
        for(String d: data){
            String[] eles = d.split("=");
            output.put(eles[0],eles[1]);
        }
        System.out.println(output);
    }

    public static void q1alt(){
        String inp = "Yogashankar";
        String s1 = inp.substring(1, inp.length()-2);
        String s2 = inp.substring(inp.length()-1);
        String s3 = String.valueOf(inp.charAt(0));
        System.out.println(s2+s1+s3);

        System.out.println(inp.substring(inp.length()-1)+inp.substring(1,inp.length()-2)+inp.charAt(0));
    }

    public static void v1() throws ParseException {
        double x = 122.34;
        Locale loc = Locale.GERMANY;
        NumberFormat format = NumberFormat.getInstance(loc);
        String s = format.format(x);
        double y = (double) format.parse(format.format(x));
        System.out.println(y);
    }

    public static void v2(){
        Pattern p = Pattern.compile("[aeiou]",Pattern.CASE_INSENSITIVE);
        int c = 0;
        String txt= "hello World, yogashankar is here for your favours";
        System.out.println("length of txt: "+txt.length());
        Matcher m = p.matcher(txt);
        while(m.find()){
            c++;
            System.out.println(txt.indexOf(m.group()));
            System.out.println(c);
        }
    }
}
