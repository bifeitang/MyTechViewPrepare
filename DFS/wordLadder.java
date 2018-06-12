package DFS;

import java.util.*;

public class wordLadder {
	public int wordLadderImp (String start, String end, Set<String> dict) {
		// Having doubt here, set or ArrayList to store the neighbor
		Map<String, Set<String>> graph = new HashMap<>();
		
		// if start and end is not inside the dictionary, add them to it
		if(!dict.contains(start))   dict.add(start);
		if(!dict.contains(end))     dict.add(end);
		
		for (String word: dict) {
			graph.put(word, new HashSet<String>());
		}
		
		// check one distance away of all nodes and link them together
		linkHelper(graph, dict);
		
		// Do BFS here, start from start, using queue and hashset
		Queue<String> queue = new LinkedList<>();
		Set<String> hash = new HashSet<>();
		
		int dist = 0;
		
		queue.offer(start);
		hash.add(start);
		
		while (!queue.isEmpty()) {
			dist++;
			System.out.println("Dist: " + dist);
			// doing this by different level
			// Had bug here, the queue size has to be fixed or if i < queue.size(), it will change every time
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String curString = queue.poll();
				System.out.println("Polled string:" + curString);
				Set<String> neighbors = graph.get(curString);
				for (String neighbor: neighbors) {
					
					if (hash.contains(neighbor)) continue;
					
					if (neighbor.equals(end)) {
						dist++;
						return dist;
					}
					System.out.println("add neighbor to queue: " + neighbor);
					queue.offer(neighbor);
					hash.add(neighbor);
				}
			}
		}
		
		return dist;
	}
	
	public void linkHelper(Map<String, Set<String>> graph, Set<String> dict) {
		
		List<String> arrayDict = new ArrayList<>(dict);
		int len = arrayDict.get(0).length();
		
		for (String word: arrayDict) {
			Set<String> neighbor = graph.get(word);
			for (int i = 0; i < len; i++) {
				for (char r = 'a'; r <= 'z'; r++) {
					String newString = word.substring(0, i) + r + word.substring(i + 1, len);
					if (dict.contains(newString)) {
						neighbor.add(newString);
					}
				}
			}
		}
	}
}

