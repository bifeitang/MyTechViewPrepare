import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {
	public static List<List<Integer>> combinationSum (int[] candidates, int target) {
		//Get rid of the repeating integer in candidates
		int[] nums = removeRepeat(candidates);
		
		Arrays.sort(candidates);
		
		List<List<Integer>> results = new ArrayList<>();
		helper(nums, target, 0, new ArrayList<>(), results);
		return results;
	}
	
	//1. Goal: take candidates, start from current, judge whether it adds up to target
	private static void helper (int[] candidates,
						 int remainTarget,
						 int startPos,
						 ArrayList<Integer> subset,
						 List<List<Integer>> results) {
		//2. Exit, Judge bound
		//if (remainTarget < 0)	return;						//Better to put the judgement inside the for loop
		if (remainTarget == 0) {
			results.add(new ArrayList<Integer>(subset));
			return;											//Forgot to return here!!!
		}
		
		//3.
		for (int i = startPos; i < candidates.length; i++) {
			if (remainTarget < candidates[i]) {				//Since the nums has already sorted in descending order
				break;
			}
			subset.add(candidates[i]);
			helper(candidates, remainTarget - candidates[i], i, subset, results);
			subset.remove(subset.size() - 1);
		}
	}
	
	private static int[] removeRepeat(int[] candidates) {
		if (candidates.length == 1)		return candidates;		//Do we still use deep copy here? No
		Arrays.sort(candidates);
		
		//Remember how to Remove duplicates!!!
		int index = 0;
		for (int i = 0; i < candidates.length; i++) {
			if (candidates[index] != candidates[i]) {
				candidates[++index] = candidates[i];
			}
		}
		
		int[] nums = new int[index + 1];
		for (int i = 0; i < index + 1; i++) {
			nums[i] = candidates[i];
		}
		
		return nums;
	}
	
	public static void main (String[] args) {
		int[] candidates = {2, 3, 4, 4, 4, 6, 9};
		int target = 8;
		System.out.println(combinationSum (candidates, target));
	}
}
