/**
 * One little trick:
 * Every integer in the list can only use once
 * Integer in the list may repeat
 * So the same integer may appear twice, which leads to the repeat of subset
 * Use HashTable to avoid remove subset
 * */
import java.util.*;

public class combinationSumII {
	public static List<List<Integer>> combinationSum2(int[] num, int target) {
		if (num == null)	return null;
		
		List<List<Integer>> results = new ArrayList<>();
		if (num.length == 0) {
			results.add(new ArrayList<Integer>());
			return results;
		}
		
		Arrays.sort(num);
		
		Set<List<Integer>> check = new HashSet<>();
		//helper function to do the traversal
		helper(num, target, 0, results, new ArrayList<Integer>(), check);
		return results;
	}
	
	//1.Goal: select nums from nums, add it to the subset, when reach target, add to results
	private static void helper (int[] nums,
								int remainTarget,
								int startPos,
								List<List<Integer>> results,
								List<Integer> subset,
								Set<List<Integer>> check) {
		//3. Exit
		if (remainTarget == 0) {
			if (!check.contains(subset)) {
				results.add(new ArrayList<Integer>(subset));
				check.add(subset);
				return;
			}
		}
		//2. DFS
		for (int i = startPos; i < nums.length; i++) {
			if (nums[i] > remainTarget)	break;
			subset.add(nums[i]);
			helper(nums, remainTarget - nums[i], i + 1, results, subset, check);
			subset.remove(subset.size() - 1);
		}
		
		return;
	}
	
	//Or use a simple clause to solve the problem
	private void helper(int[] candidates,
						int startIndex,
						List<Integer> combination,
						int target,
						List<List<Integer>> results) {
		if (target == 0) {
			results.add(new ArrayList<Integer>(combination));
			return;
		}
		
		for (int i = startIndex; i < candidates.length; i++) {
			//Here, second/third/more i's value equals to its previous one, mains its already added once
			if (i != startIndex && candidates[i] == candidates[i - 1]) {
				continue;
			}
			if (target < candidates[i]) {
				break;
			}
			combination.add(candidates[i]);
			helper(candidates, i + 1, combination, target - candidates[i], results);
			combination.remove(combination.size() - 1);
		}
	}
	
	public static void main (String[] args) {
		int[] num = {1, 1, 4, 5, 3, 7, 3, 9};
		System.out.println(combinationSum2(num, 12));
	}
}
