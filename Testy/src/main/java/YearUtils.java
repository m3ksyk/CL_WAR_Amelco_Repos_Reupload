public class YearUtils {

    public boolean isYearLeap(int year) {
        boolean isLeapYear = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));

        if (isLeapYear) {
            return true;
        } else
            return false;
    }

}
