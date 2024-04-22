package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Aggregate {
    public static void main(String[] args) {
        List<candy> data = new ArrayList<>();
        data.add(new candy("27-08-2022","kitkat",20));
        data.add(new candy("27-08-2022","alpenliebe",30));
        data.add(new candy("27-08-2022","sugary",10));
        data.add(new candy("25-08-2022","kitkat",20));
        data.add(new candy("28-08-2022","alpenliebe",30));
        data.add(new candy("28-08-2022","sugary",10));
        data.add(new candy("29-08-2022","kitkat",20));
        data.add(new candy("29-08-2022","alpenliebe",30));
        data.add(new candy("29-08-2022","hersheys",10));
        data.add(new candy("25-08-2022","liebenpop",20));
        data.add(new candy("25-08-2022","alpenliebe",30));
        data.add(new candy("25-08-2022","sugary",10));

        int totalKitkat = data.stream().filter(x->x.name.equalsIgnoreCase("kitkat")).mapToInt(x->x.consumption).sum();
        System.out.println("kitkat total "+totalKitkat);
        Map<String,Integer> entry = new HashMap<>();
        HashMap<String, Map<String, Integer>> history = new HashMap<String, Map<String, Integer>>();
        for(candy c:data){
           String date = c.date;
           String name = c.name;
           int consumption = c.consumption;
           if(history.containsKey(date)){
               entry = history.getOrDefault(data,new HashMap<>());
           }

           entry.put(name,entry.getOrDefault(name,0)+consumption);
           history.put(date,entry);
        }
        int totalAlpenliebe = data.stream().filter(d->"alpenliebe".equalsIgnoreCase(d.name)).mapToInt(d->d.consumption).sum();
        System.out.println(totalAlpenliebe);

        Map<Integer,List<candy>> perConsumption = data.stream().collect(groupingBy(d->d.consumption));
        Map<String,List<candy>> perDay = data.stream().collect(groupingBy(d->d.date));
        perConsumption.get(10).stream().forEach(c-> System.out.println(c.consumption+"\t"+c.date+"\t"+c.name));
        int sum = perDay.get("25-08-2022").stream().flatMapToInt(d-> IntStream.of(d.consumption)).sum();
        System.out.println(sum);
        System.out.println(data.stream().filter(d -> d.name.equalsIgnoreCase("kitkat")).sorted(candy::compareTo).collect(Collectors.toList()));

        Map<String, Double> avg = data.stream()
                .collect(
                        groupingBy(
                                candy::getName,
                                Collectors.averagingInt(candy::getConsumption)
                        )
                );
        System.out.println(avg);
    }

    static class candy implements Comparable<candy> {
        String date;
        String name;
        int consumption;

        candy(String date,String name,int consumption){
            this.date = date;
            this.name = name;
            this.consumption = consumption;
        }
        int getConsumption(){
            return this.consumption;
        }

        String getName(){
            return this.name;
        }

        @Override
        public int compareTo(candy o) {
            return o.getConsumption()-this.getConsumption();
        }
    }
}
