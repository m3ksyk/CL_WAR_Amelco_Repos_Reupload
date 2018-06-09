package pl.coderslab.lambdaExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String str = scanner.nextLine();
        while(!str.equals("quit")){
            list.add(str);
            str = scanner.nextLine();
        }
        //sorts the list
        list.sort((a,b) -> a.compareToIgnoreCase(b));
        //prints the list
        list.forEach(value -> System.out.println(value));
    }
}
