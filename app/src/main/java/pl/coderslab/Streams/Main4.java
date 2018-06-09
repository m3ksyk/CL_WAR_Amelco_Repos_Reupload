package pl.coderslab.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main4 {
    public static void main(String[] args) {
        List<String> fruits =
                Arrays.asList("orange", "lemon", "banana", "peach",  "plum",
                        "cherry", "apple", "pomelo", "something");

        fruits.stream()
                .forEach(String -> System.out.println(String.length()) );

        List<String> sortedFruits = fruits.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted fruits");
        sortedFruits.forEach(System.out::println);

        fruits.stream()
                .filter(String -> ( String.contains("c")))
                .forEach(System.out::println);

        int sum = fruits
                .stream()
                .mapToInt(str -> str.length())
                .sum();

        System.out.println("sum: " + sum);

        List<String> threeFruits = fruits.stream()
                .limit(3)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Three fruits");
        threeFruits.forEach(System.out::println);

    }
}
