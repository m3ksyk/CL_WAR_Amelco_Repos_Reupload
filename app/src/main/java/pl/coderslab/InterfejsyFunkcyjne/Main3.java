package pl.coderslab.InterfejsyFunkcyjne;

import java.util.ArrayList;
import java.util.List;

public class Main3 {
    static <T, S> List<T> create(List<S> src, Filter<S> f, Transform<T, S> t) {
    List<T> srcOut = new ArrayList<>();
        for (S s : src) {
            if (f.check(s)) {
                System.out.println(t.transform(s));
                srcOut.add(t.transform(s));
            }
        }
        return  srcOut;
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

        create(listNumbers, v -> nf.check(v), v -> nt.transform(v));

        List listNumbers2 = Main3.create(listNumbers, nf::check, nt);
    }
}
