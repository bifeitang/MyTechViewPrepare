import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {
	public List<List<Integer>> combinationSum (int[] candidates, int target) {
		//Get rid of the repeating integer in candidates
		candidates = removeRepeat(candidates);
		
		Arrays.sort(candidates);
		
		List<List<Integer>> results = new ArrayList<>();
		helper(candidates, target, 0, new ArrayList<>(), results);
		return results;
	}
	
	//1. Goal: take candidates, start from current, judge whether it adds up to target
	private void helper (int[] candidates,
						 int target,
						 int startPos,
						 ArrayList<Integer> subset,
						 List<List<Integer>> results) {
		//2. Exit
		if ()
		//3.
		for (int i = startPos; i < candidates.length; i++) {
			subset.add(candidates[i]);
			helper(candidates, target, startPos, subset, results);
		}
	}
	
	private int[] removeRepeat(int[] candidates) {
		return candidates;
	}
}
