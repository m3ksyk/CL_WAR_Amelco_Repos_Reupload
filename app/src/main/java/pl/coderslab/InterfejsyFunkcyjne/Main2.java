package pl.coderslab.InterfejsyFunkcyjne;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    static <T, S> void printList(List<S> src, Filter<S> f, Transform<T, S> t) {
        for (S s : src) {
            if (f.check(s)) {
                System.out.println(t.transform(s));
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
        NumberTransform nt = new NumberTransform();
        NumberFilter nf = new NumberFilter();
        //using lambda expression
        printList(listNumbers, v -> nf.check(v), v -> nt.transform(v));
        //even shorter, without creating nf and nt objects, just with filter  and transform implementation
        printList(listNumbers, v -> v < 20, v -> v-1);

    }
}
