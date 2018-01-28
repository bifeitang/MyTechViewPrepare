import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutation {
	public static List<List<Integer>> permutation (int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		if (nums == null)	return results;
		if (nums.length == 0) {
			results.add(new ArrayList<>());
			return results;
		}
		List<Integer> item = new ArrayList<>();
		helper(nums, new HashSet<>(), item, results);
		return results;
	}
	
	//1. Goal: find a proper combination of nums in numbers, remember who has already in the list
	private static void helper (int[] nums,
								HashSet<Integer> used,
								List<Integer> item,
								List<List<Integer>> results) {
		//3. Exit: when item is complete
		if (item.size() == nums.length) {
			results.add(new ArrayList<>(item));
			return;
		}
		
		//2. Loop
		for (int i = 0; i < nums.length; i++) {			//Had problem here, Why I'm using i < nums.length -1 !!!! zz
			if (used.contains(nums[i]))	continue;
			item.add(nums[i]);
			used.add(nums[i]);
			helper(nums, used, item, results);
			item.remove(item.size() - 1);
			used.remove(nums[i]);
		}
		return;
	}
	
	public static void main (String[] args) {
		int[] test = {1, 2, 3, 4};
		System.out.println(permutation(test));
	}
}
