package DFS;

import java.util.ArrayList;
import java.util.List;

public class splitString {
	
	public static List<List<String>> getCombination(String s) {
		List<List<String>> result = new ArrayList<>();
		List<String> curr = new ArrayList<>();
		
		DFS(s, curr, result);
		return result;
	}
	
	public static void DFS (String s, List<String> curr, List<List<String>> result) {
		String example = "new string";
		if (s.equals("")) {
			result.add(new ArrayList<String>(curr));
			return;
		}
		
		for (int i = 1; i<=2; i++) {
			if (i <= s.length()) {
				curr.add(s.substring(0, i));
				// No need to -1 here!
				DFS(s.substring(i, s.length()), curr, result);
				curr.remove(curr.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		String s = "new string";
		System.out.println(getCombination(s));
	}
	
}
