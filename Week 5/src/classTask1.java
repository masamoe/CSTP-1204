public class classTask1 {
    public static int dayOfYear(int month, int dayOfMonth, int year) {
        int[] monthLengths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = dayOfMonth;

        if (month >= 2) {
            for (int m = 1; m < month; ++m) {
                day += monthLengths[m];
            }
        }
        System.out.println(day);
        return day;
    }

    public static void main(String[] args) {
        int myMonth = 3;
        int myDay = 15;

        dayOfYear(myMonth, myDay, 2022);
    }
}


