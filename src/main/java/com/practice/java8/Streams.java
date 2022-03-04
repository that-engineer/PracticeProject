package com.practice.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //
       // System.out.println(list1.stream().max(Integer::compare).get());
       // System.out.println(list1.stream().max(Comparator.reverseOrder()).get());
        List<String> list2 = Arrays.asList("G", "E", "E", "K","g", "e", "e", "k");
      //  System.out.println(list2.stream().max(Comparator.comparing(String::valueOf)).get());
        String[] array = { "Geeks", "for", "GeeksforGeeks","GeeksQuiz" };
       // System.out.println(Arrays.stream(array).max((str1,str2)->Integer.compare(str1.length(),str2.length())).get());
       // System.out.println(Arrays.stream(array).max((str1,str2)->Character.compare(str1.charAt(str1.length()-1),str2.charAt(str2.length()-1))).get());
      //  System.out.println(Arrays.stream(array).max(Comparator.comparingInt(str -> str.charAt(str.length() - 1))).get());
        Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
       // streamBuilder.forEach(System.out::println);
        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
       // streamIterated.forEach(itr->System.out.print(itr+", "));

        Stream<String> stream = Stream.of("a", "b", "c").filter(element -> element.contains("b"));
        Optional<String> anyElement = stream.findAny();
       // System.out.println(anyElement.get());
        /**
         * This would throw an IllegalStateException, a runtime Exception.
         * Hence, cannot be detected at compile time
         */
        //System.out.println(stream.findFirst().get());
        List<String> strList = Stream.of("a", "b", "c","bb","ab").filter(element -> element.contains("b")).collect(Collectors.toList());
        //System.out.println(strList.stream().findAny().get());
        //System.out.println(strList.stream().findFirst().get());
        List<String> list = Arrays.asList("abc1", "abc2", "abc3","abc4","abc5","abc6");
        long size = list.stream().skip(1).map(element -> element.substring(0, 3)).count();
       // System.out.println(size);
       // list.stream().skip(2).map(element -> element.substring(3, 4)).collect(Collectors.toList()).forEach(str->System.out.print(str+","));
        /**
         *  Refer Lazy Invocation here -  https://www.baeldung.com/java-8-streams
         */
        List<String> list3 = Arrays.asList("abc1", "abc2", "abc3");
        Stream<String> stream1 = list.stream().filter(element -> {
            //System.out.println("calling ");
            return element.contains("2");
        });
        Optional<String> streamOp = list.stream().filter(element -> {
            //System.out.println("filter() was called");
            return element.contains("2");
        }).map(element -> {
            //System.out.println("map() was called");
            return element.toUpperCase();
        }).findFirst();
        //System.out.println(streamOp.get());

        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar"));

        int summingPrice = productList.stream().collect(Collectors.summingInt(Product::getPrice));
        int summingPriceAlt1 = productList.stream().mapToInt(Product::getPrice).sum();
        int summingPriceAlt2 = productList.stream().map(Product::getPrice).reduce(Integer::sum).get();
        int summingPriceAlt3 = productList.stream().map(Product::getPrice).reduce((a,b)->a+b).get();
        int summingPrice4 = productList.stream().collect(Collectors.summingInt(Product::getPrice));
       // System.out.println(summingPrice+" , "+summingPriceAlt1);

        List<List<Integer> > number = new ArrayList<>();

        // adding the elements to number arraylist
        number.add(Arrays.asList(1, 2));
        number.add(Arrays.asList(3, 4));
        number.add(Arrays.asList(5, 6));
        number.add(Arrays.asList(7, 8));

        System.out.println("List of list-" + number);

        // using flatmap() to flatten this list
        List<Integer> flatList
                = number.stream()
                .flatMap(list4 -> list4.stream())
                .collect(Collectors.toList());

        List<Integer> flatList1
                = number.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        // printing the list
        System.out.println("List generate by flatMap-"
                + flatList);
    }
}

class Product{
    private int price;
    private String name;

    public Product(int id, String name) {
        this.price = id;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
