package DFS;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations {
	
	public List<String> letterCombinations(String digits) {
		String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		if (digits == null)		return null;
		
		List<String> result = new ArrayList<>();
		if (digits.length() == 0)	return result;
		
		// use a number list to convert the digits to numbers
		int len = digits.length();
		int[] nums = new int[len];
		for (int i = 0; i < len; i++) {
			nums[i] = Character.getNumericValue(digits.charAt(i));
		}
		
		helper(result, nums, dict, 0, "");
		
		return result;
	}
	
	// only need two integers: start and next
	private void helper(List<String> result, int[] nums, String[] dict, int level, String sub) {
		// exit of the helper
		if (sub.length() == nums.length) {
			result.add(sub);
			return;
		}
		
		//3. body
		char[] cur = dict[nums[level]].toCharArray();
		for (char c: cur) {
			helper(result, nums, dict, level + 1, sub + c);
		}
	}
}
