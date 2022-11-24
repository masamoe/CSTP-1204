package Week12;

public class main {

    static void verticalPrint_recursive(int n) {
        if (n < 10) {
            System.out.println(n);
        } else {
            verticalPrint_recursive(n / 10);
            System.out.println(n % 10);
        }
    }

    static void verticalPrint_iterative(int n) {
        int temp = n;
        int count = 0;
        while (temp > 0) {
            temp /= 10;
            count++;
        }
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = n % 10;
            n /= 10;
        }
        for (int i = count - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    static int fibonacci_recursive(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2);
        }
    }

    static int fibonacci_iterative(int n) {
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 0; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        int x = 1234;
        verticalPrint_recursive(x);

    }
}
