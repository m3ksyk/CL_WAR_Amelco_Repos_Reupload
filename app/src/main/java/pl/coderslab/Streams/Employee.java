package pl.coderslab.Streams;

import java.util.Date;

public class Employee {
   private String name;
   private String surname;
   private Double salary;
   private String sex;
   private Date birthday;

    public Employee(String name, String surname, Double salary, String sex, Date birthday) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.sex = sex;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
