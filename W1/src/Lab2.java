import java.util.Arrays;
public class Lab2 {
    String plusOne(int[] arr) {
        int lastIndex = arr.length-1;
        arr[lastIndex]++;
        return Arrays.toString(arr);
    }

    int removeElement(int[] nums, int val) {
        int length = (nums.length - 1);
        int k = 0;

        for(int i = 0; i < length; i++)
            if(nums[i] == val) {
                for (int j = i; j < length; j++)
                    nums[j] = nums[j + 1];
                k++;
            }
        return k;
    }
}
