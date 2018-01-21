public class Prob136 {
	public static void main(String[] args) {
		int[] testCase = {1, 1, 3};
		System.out.println(uniqueNumber(testCase));
	}
	
	public static int uniqueNumber(int[] nums) {
		if (nums == null) return -1;
		int result = 0;
		for (int x : nums) result ^= x;
		return result;
	}
}
