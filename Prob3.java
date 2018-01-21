import sun.nio.cs.ext.MacHebrew;

import java.util.HashSet;
import java.util.*;

public class Prob3 {
	/*
	 * Given a string, find the length of the longest substring without repeating characters.
	 */
	public static void main(String[] args) {
		String test = "eimxigaeomgaeoomls";
		System.out.println(findLongestSub(test));
	}
	
	public static int findLongestSub(String srcString) {
		int subLongest = -1;
		int start = 0, end = 0;
		Set<Character> window = new HashSet<>();
		
		while (end < srcString.length() && start <= end) {    //Had problem here, should be start <= end
			if (window.add(srcString.charAt(end))) {
				end++;
			} else {
				subLongest = Math.max(subLongest, end - start);
				while (srcString.charAt(start) != srcString.charAt(end)) {
					window.remove(srcString.charAt(start));    //Had problem here, remove the value before adding
					start++;
				}
				start++;
				end++;                                        //Had Problem here, forget end++
			}
		}
		subLongest = Math.max(subLongest, end - start);
		return subLongest;
	}
}
