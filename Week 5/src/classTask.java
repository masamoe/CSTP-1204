public class classTask {
    public enum Month {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER};
    public static boolean isLeapYear(int year){
        boolean isLeap = false;
        if(year % 4 != 0){
            isLeap = false;
        }
        else if(year % 100 != 0){
            isLeap = true;
        }
        else if(year % 400 != 0){
            isLeap = false;
        }
        else{
            isLeap = true;
        }
        return isLeap;
    }
    public static int dayOfYear(Month month, int dayOfMonth, int year) {

        int[] monthLengths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = dayOfMonth;

        if(isLeapYear(year)){
            monthLengths[month.ordinal()+1] = 29;
        }

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


