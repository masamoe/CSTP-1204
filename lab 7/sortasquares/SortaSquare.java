// package sortasquares;

import java.util.Set;
import java.util.HashSet;

public class SortaSquare {

	/**
	 * Return a subset of SortaSquares from the integers in set s.
	 * 
	 * @param s
	 *            the set from which we want to extract SortaSquares
	 * @return a subset with all the SortaSquares in s
	 */
	public static Set<Integer> getSortaSquares(Set<Integer> s) {
        HashSet<Integer> Squares = new HashSet<Integer>();
        for (Integer i : s) {
            if (isSortaSquare(i)) {
                Squares.add(i);
            }
        }
        return Squares;
	}

    private static boolean isSortaSquare(int i) {
        int n = -1;
        int sqrt = (int) Math.sqrt(i);
        if (sqrt * sqrt == i) {
            n = sqrt;
        } else if ((sqrt + 1) * (sqrt + 1) == i) {
            n = sqrt + 1;
        }
        if (n == -1) {
            return false;
        }
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum * sum == i;
    }    
}