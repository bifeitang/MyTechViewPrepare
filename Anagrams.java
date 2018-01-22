import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Anagrams {
	/**
	 * Realize a function to return repeated substrings*/
	public static List<String> getAnagrams (String[] strs) {
		List<String> results = new ArrayList<String>();
		HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
		
		for (String str: strs) {
			int[] createKey = new int[26];
			for (int i  = 0; i < str.length(); i++) {
				createKey[str.charAt(i) - 'a']++;
			}
			int getKey = hashValueConverter(createKey);
			if (!map.containsKey(getKey)) {	//Remember the way to check whether a key is in the map
				map.put(getKey, new ArrayList<>());
			}
			
			map.get(getKey).add(str);		//Remember the way to put a value under a given key
		}
		
		for (ArrayList<String> tmp: map.values()) {
			if (tmp.size() > 1)
				results.addAll(tmp);		//Have to use addAll function to add a key to the list
		}
		
		return results;
	}
	
	/**
	 * A crucial function to design
	 * Goal: Make sure different value hash to the diffrent position*/
	private static int hashValueConverter (int[] val) {
		int hash = 0;
		int a = 378551;
		int b = 63689;
		for (int i = 0; i < 26; i++) {
			hash = a*hash + val[i];
			a = a * b;
		}
		return hash;
	}
	
	public static void main (String[] args) {
		String[] test = {"abc", "cba", "cab", "de"};
		System.out.println(getAnagrams(test));
	}
}
