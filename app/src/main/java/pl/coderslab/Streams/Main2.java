package pl.coderslab.Streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        Employee employee1 = new Employee("John", "Doe", 5000.00, "m", new Date("1980/10/10"));
        Employee employee2 = new Employee("Jane", "Doe", 2500.00, "f", new Date("1995/01/10"));
        Employee employee5 = new Employee("Joane", "Doe", 2500.00, "f", new Date("1997/01/10"));
        Employee employee3 = new Employee("John", "Novak", 4000.00, "m", new Date("1975/10/10"));
        Employee employee4 = new Employee("James", "Townsend", 4000.00, "m", new Date("1999/11/12"));

        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        list.add(employee5);

        list.stream()
                .filter(employee -> ( employee.getSurname().startsWith("N")))
                .forEach(System.out::println);


        list.stream()
                .filter(employee -> {
                    int age = LocalDate.now().getYear() - employee.getBirthday().getYear();
                    return (age >= 30 && age<= 45);
                })
                .forEach(System.out::println);

        List<Employee> newList = list;
        newList = newList.stream()
                .map(employee -> {
                    int age = LocalDate.now().getYear() - employee.getBirthday().getYear();
                    if (age >= 20 && age<= 30 && employee.getSex().equals("f") && employee.getSalary() < 3500){
                        employee.setSalary((employee.getSalary()) * 1.05);
                        return employee;
                    }else {
                        return employee;
                    }
                })
                .collect(Collectors.toList());

        System.out.println("before");
        list.forEach(System.out::println);
        System.out.println("After");
        newList.forEach(System.out::println);

    }
}
