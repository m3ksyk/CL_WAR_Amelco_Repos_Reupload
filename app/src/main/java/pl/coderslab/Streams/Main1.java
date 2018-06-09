package pl.coderslab.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main1 {
    public static void main(String[] args) {
        List<String> fruits =
                Arrays.asList("orange", "lemon", "peach", "banana", "plum",
                        "cherry", "apple", "pomelo", "something");
        fruits.stream()
                .filter(s -> ( s.startsWith("a") || s.startsWith("s") ))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        List<String> fruits2= fruits.stream()
                .unordered()
                .distinct()
                .filter(s -> ( s.length() == 5 ))
                .collect(Collectors.toList());

        fruits2.forEach(System.out::println);


        String str = fruits.stream()
                .sorted()
                .map(el -> el.substring(0,3))
                .collect(Collectors.joining(","));

        System.out.println(str);
    }
}
