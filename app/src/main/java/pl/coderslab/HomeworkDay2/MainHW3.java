package pl.coderslab.HomeworkDay2;


import java.util.function.Consumer;
import java.util.function.Function;

public class MainHW3 {

    public static void main(String[] args) {
        String sample = "CODERSLAB";
//used consumer instead of function
        Consumer<String> consumer = (s1) -> System.out.println(sample.substring(2, sample.length()-2).toLowerCase());
        consumer.accept(sample);

    }
}
