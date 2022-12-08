package ranges;

import java.util.ArrayList;
import java.util.HashMap;

public class OverlappingRanges {

	/**
	 * Returns the smallest integer that is present in the maximum number of
	 * input ranges
	 * 
	 * @param startPoints
	 *            the list of starting points for the ranges
	 * @param endPoints
	 *            the list of end points for the ranges
	 * @return the smallest integer that is present in the maximum number of
	 *         ranges
	 * @throws NoOverlapException
	 *             when there is no overlap between any of the ranges
	 */
	public static Integer maxOverlapInt(ArrayList<Integer> startPoints,
			ArrayList<Integer> endPoints) throws NoOverlapException {
		// TODO: Implement this method
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < startPoints.size(); i++) {
			for (int j = startPoints.get(i); j <= endPoints.get(i); j++) {
				if (map.containsKey(j)) {
					map.put(j, map.get(j) + 1);
				} else {
					map.put(j, 1);
				}
			}		
		}
		Integer max = 0;
		Integer maxInt = 0;
		for (Integer i : map.keySet()) {
			if (map.get(i) > max) {
				max = map.get(i);
				maxInt = i;
			}
		}
		if (max == 0) {
			throw new NoOverlapException();
		}
		return maxInt;
	}

}
