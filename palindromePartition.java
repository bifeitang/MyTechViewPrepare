import java.util.ArrayList;
import java.util.List;

/**
 * According to the answer we may not consider the Uppercase and nonAlphabetic
 */
public class palindromePartition {
	
	public static List<List<String>> partition (String s) {
		List<List<String>> results= new ArrayList<>();
		if (s == null || s.length() == 0)	return results;
		
		List<String> subStrings = new ArrayList<String>();
		helper(s, 0, new ArrayList<>(), results);
		return results;
	}
	
	//1. Goal: find the proper point to partition, which guarantee the partitioned string is palindrome
	public static void helper(String partition,
							  int startPos,
							  List<String> subStrings,
							  List<List<String>> results) {
		//2. Exit
		if (startPos == partition.length()) {
			results.add(new ArrayList<>(subStrings));
			return;
		}
		//3. DFS
		for (int i = startPos; i < partition.length(); i++) {
			String subString = partition.substring(startPos, i + 1);
			if (! isPalindrome(subString))	continue;
			subStrings.add(subString);
			helper(partition, i + 1, subStrings, results);
			subStrings.remove(subStrings.size() -1);
		}
	}
	
	private static boolean isPalindrome (String test) {
		for (int i = 0, j = test.length() - 1; i < j; i++, j--) {
			if (test.charAt(i) != test.charAt(j))	return false;
		}
		return true;
	}
	
	public static void main (String[] args) {
		String test = "aab";
		System.out.println(partition(test));
	}
}
