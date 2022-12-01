package numberlinetravel;

public class NumberLineTravel {

    /**
     * Determine how many unique cities you can visit via monorail if you are
     * limited to k kilometers per trip. You are permitted an infinite number of
     * trips. You are given an array that represents city locations and you
     * start your journey at the first city in the array.
     * 
     * @param x
     *          is an array that represents the cities on a number line. The
     *          distance between city x[i] and city x[j] is | x[i]-x[j] |
     *          kilometers.
     * @param k
     *          represents the maximum distance, in kilometers, that one can
     *          travel in one monorail trip. k should be greater than 0.
     * @return the number of new cities that one can visit starting from x[0].
     *         x[0] is not included in the count.
     */
    public static int howManyCitiesCanIVisit(int[] x, int k) {
        int count = 0;
        int currentCity = x[0];
        int[] visitedCities = new int[x.length];
        for (int i = 1; i < x.length; i++) {
            if (!isVisited(x[i], visitedCities)) {
                if (currentCity - x[i] <= k && currentCity - x[i] > 0) {
                    count++;
                    currentCity = x[i];
                } else if (x[i] - currentCity <= k && x[i] - currentCity > 0) {
                    count++;
                    currentCity = x[i];
                }
                currentCity = x[i];
                visitedCities[i] = currentCity;
            }
        }
        return count;
    }

    private static boolean isVisited(int i, int[] visitedCities) {
        for (int j = 0; j < visitedCities.length; j++) {
            if (i == visitedCities[j]) {
                return true;
            }
        }
        return false;
    }

}
