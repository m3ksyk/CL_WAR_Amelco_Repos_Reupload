package pl.coderslab.HomeworkDay2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class MainHW2 {

    public static Predicate<String> longerThan4() {
        return p -> p.length() > 4;
    }
    public static Predicate<String> hasB() {
        return p -> p.contains("b");
    }
    public static Predicate<String> endsWithA() {
        return p -> Objects.equals(p.charAt(p.length() - 1), 'a');
    }

    public static List filterList(List<String> list, Predicate predicate){
        List<String> outList = new ArrayList<>();

        for (String s : list) {
            if (predicate.test(s)==true) {
                outList.add(s);
                System.out.println(s);
            }
        }
        return outList;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("tree", "bird", "park", "snow", "computer",
                "i jeszcze jakiś inny napis, który na końcu ma a");
        System.out.println("Ends with a:");
        filterList(list, endsWithA());
        System.out.println("longer than 4:");
        filterList(list, longerThan4());
        System.out.println("has b:");
        filterList(list, hasB());
    }
}
