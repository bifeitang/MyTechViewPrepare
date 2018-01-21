import java.util.Arrays;
import java.util.HashMap;


public class Prob760 {
	/*Find Anagram Mappings*/
	public static void main(String[] args) {
		int[] A = {12, 28, 46, 32, 50};
		int[] B = {50, 12, 32, 46, 28};
		System.out.println(Arrays.toString(findAnagramMapping(A, B)));    //Notice how to use "toString", to print array
	}
	
	public static int[] findAnagramMapping(int[] A, int[] B) {
		HashMap<Integer, Integer> mapA = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < A.length; i++) {
			if (mapA.get(B[i]) == null)
				mapA.put(B[i], i);
		}
		
		int[] result = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			result[i] = mapA.get(A[i]);
		}
		
		return result;
	}
}
