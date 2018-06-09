package pl.coderslab.HomeworkDay2;

public class Checker implements ZeroToHundred {
    @Override
    public boolean check(Object o) {

        return (((int)o > 0) && ((int)o < 100));
    }
}
