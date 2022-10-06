public class classTask {
    public enum Month {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER};
    public static int dayOfYear(Month month, int dayOfMonth, int year) {

        int[] monthLengths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = dayOfMonth;

        if (month.ordinal()+1 >= 2) {
            for (int m = 1; m < month.ordinal()+1; ++m) {
                day += monthLengths[m];
            }
        }
        System.out.println(day);
        return day;
    }

    public static void main(String[] args) {
        int myMonth = 3;
        int myDay = 15;

        dayOfYear(Month.MARCH, myDay, 2022);
    }
}


