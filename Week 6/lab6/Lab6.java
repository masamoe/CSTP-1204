package lab6;

import java.util.*;

public class Lab6 {

    public int findUnique(String input) {
        HashMap<Character, Integer> charRepeats = new HashMap<Character, Integer>();
        int len = input.length();

        for (int i = 0; i < len; i++) {
            char character = input.charAt(i);
            charRepeats.put(character, charRepeats.getOrDefault(character, 0) + 1);
        }

        for (int i = 0; i < len; i++) {
            if (charRepeats.get(input.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    // public static int add(int x, int y) {
    // int sum = x + y;
    // return sum;
    // }

}
