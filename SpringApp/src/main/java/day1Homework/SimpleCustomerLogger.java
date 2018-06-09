package day1Homework;

import java.util.Date;

public class SimpleCustomerLogger implements CustomerLogger {
    @Override
    public void log() {
        Date date = new Date();
        System.out.println( date + " : Customer operation");
    }
}
