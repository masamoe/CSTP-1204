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
        while (sqrt > 0) {
            int a = 1;
            while (a < sqrt) {
                if (a * a + sqrt * sqrt == i) {
                    n = sqrt;
                    break;
                }
                a++;
            }
            if (n != -1) {
                break;
            }
            sqrt--;
        }
        return n != -1;
    }

}