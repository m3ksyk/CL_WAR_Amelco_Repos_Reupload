package pl.coderslab.lambdaExpressions;

import java.util.function.Predicate;

public class Main2 {
    static void printValue(Object value, Predicate<Object> f){
       if(f.test(value)){
           System.out.println(value);
       }
    }

    public static Predicate<Object> isString() {
        return p -> p.getClass().equals(String.class);
        //return p -> p instanceof String;
    }

    public static void main(String[] args) {
        printValue("111", isString());
        printValue(111, isString());

        printValue("Dupa", val -> val instanceof String);
    }
}
