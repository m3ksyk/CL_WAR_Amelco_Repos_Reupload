package pl.coderslab.InterfejsyFunkcyjne;

import java.util.ArrayList;
import java.util.List;

public class Main1 {

    static <T> void printList(List<T> src, Filter<T> f) {
        for (T s : src) {
            if (f.check(s)) {
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> listNumbers = new ArrayList<>();
        listNumbers.add(123);
        listNumbers.add(500);
        listNumbers.add(15);
        listNumbers.add(20);
        listNumbers.add(1);

        NumberFilter nf = new NumberFilter();
        //using lambda expression
        printList(listNumbers, v -> nf.check(v));
        //even shorter, without creating nf object, just with filter implementation 'v<20'
        printList(listNumbers, v -> v < 20);


    }
}
