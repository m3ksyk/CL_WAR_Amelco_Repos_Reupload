package pl.coderslab.lambdaExpressions;

import java.util.function.Predicate;

public class Main3 {
    static void printValue(Object value, Predicate<Object> f){
        if(f.test(value)){
            System.out.println(value);
        }
    }

    public static void main(String[] args) {

        printValue(123, val -> val instanceof Number);
    }
}
