package pl.coderslab.HomeworkDay2;



import java.util.ArrayList;
import java.util.List;

public class MainHW1 {
    static <T> void printList(List<T> src, ZeroToHundred<T> v) {
        for (T s : src) {
            if (v.check(s)) {
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {
        Checker checker = new Checker();

        List<Integer> listNumbers = new ArrayList<>();
        listNumbers.add(123);
        listNumbers.add(500);
        listNumbers.add(15);
        listNumbers.add(20);
        listNumbers.add(-1);

        printList(listNumbers, v -> checker.check(v));

    }

}
