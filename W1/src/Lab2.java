import java.util.Arrays;
public class Lab2 {
    String plusOne(int[] arr) {
        int lastIndex = arr.length-1;
        arr[lastIndex]++;
        return Arrays.toString(arr);
    }

    int removeElement(int[] numbers, int val) {
        int size = numbers.length - 1;
        int k = 0;

        for(int i = 0; i < size; i++)
            if(numbers[i] == val) {
                for (int j = i; j < size; j++)
                    numbers[j] = numbers[j + 1];
                size--;
                k++;
            }

        return k;
    }
}
