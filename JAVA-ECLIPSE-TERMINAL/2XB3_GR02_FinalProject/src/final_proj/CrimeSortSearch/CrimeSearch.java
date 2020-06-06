/** @file CrimeSearch.java
@author Jash Mehta
@brief Searches for a crime within a given range
@date February 28,2020
*/

package final_proj.CrimeSortSearch;

import java.util.Map;

public class CrimeSearch {

	public static String search(String inputKey, int crimeKey) {
		Map<String, Integer> sortedCrime = CrimeSorting.crimeSort(inputKey);
		String[][] crimeList = new String[sortedCrime.size()][2];
		int i = 0;
		for (Map.Entry mapElement : sortedCrime.entrySet()) {
			if (!mapElement.equals(null)) {
				crimeList[i][0] = (String) mapElement.getKey();
				crimeList[i][1] = String.valueOf(mapElement.getValue());
				i++;
			}
		}
		
		if(crimeList[0][0].equals("-1")) {
			return "Does Not Exist";
		}

		if (indexOf(crimeList, crimeKey) != -1) {
			return crimeList[indexOf(crimeList, crimeKey)][0];
		} else {
			return "Does Not Exist";
		}
	}

	private static int indexOf(String[][] a, int key) {
		int lo = 0;
		int hi = a.length - 1;
		int mid = lo + (hi - lo) / 2;
		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			if (key < Integer.parseInt(a[mid][1])) {
				hi = mid - 1;
			} else if (key > Integer.parseInt(a[mid][1])) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		
		if(mid+1 > a.length || mid-1 < a.length) {
			return mid;
		}
		if(Math.abs(key - Integer.parseInt(a[mid-1][1])) < Math.abs(key - Integer.parseInt(a[mid][1]))) {
			return mid-1;
		}
		else if(Math.abs(key - Integer.parseInt(a[mid][1])) < Math.abs(key - Integer.parseInt(a[mid+1][1]))) {
			return mid;
		}
		else {
			return mid+1;
		}
	}

}
