package pl.coderslab.HomeworkDay2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Methods {
    //method returns a list of elements fullfilling the condition given in predicate
    static <T> List<T> search(Collection<T> collection, Predicate<T> predicate){
        List<T> outList = new ArrayList<T>();
        for (T t:collection) {
            if(predicate.test(t)){
                outList.add(t);
            }
        }

        return outList;
    }
//    metoda ma przekształcić elementy za pomocą function i dodać do nowej zwracanej kolekcji

    static <S, T> List<T> changeCollection(Collection<T> collection, Function<S, T> function){
        List<T> outList = new ArrayList<T>();
        for (T t:collection) {
            function.apply((S) t);
            outList.add(t);
        }
        return outList;
    }

    //method changes elements using consumer
    static <T> void consumeCollection(Collection<T> collection, Consumer<T> consumer){

            for (T t : collection) {
                 consumer = (u) -> System.out.println("DO stuff to: " + t);
                 consumer.accept(t);
            }
    }

}


