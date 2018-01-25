import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	public static List<List<Integer>> subsets (int[] nums) {
		//Have to make sure what we will return when nums is null and 0 respectively
		if (nums == null) {
			return null;
		}
		
		List<List<Integer>> results = new ArrayList<>();
		
		if (nums.length == 0) {
			results.add(new ArrayList<Integer>());	//Pay attention to return the ArrayList, the concrete realization for List
			return results;
		}
		
		Arrays.sort(nums);		//Remember how we use sort function
		helper(new ArrayList<Integer>(), nums, 0, results);
		return results;
	}
	
	//Use recursion here -> Find all the nums start with subsets
	private static void helper (ArrayList<Integer> subset,
						 int[] nums,
						 int startIndex,
						 List<List<Integer>> results) {
		//2.Split the recursion
		results.add(new ArrayList<Integer>(subset));	//I was directly adding .add(subset) here!
		
		for (int i = startIndex; i < nums.length; i++) {
			subset.add(nums[i]);
			helper(subset, nums, i + 1, results);
			subset.remove(subset.size() - 1);
		}
		
		//exit of the code
		return;
	}
	
	public static void main (String[] args) {
		int[] nums = {1, 2, 3};
		System.out.println(subsets(nums));
	}
}
