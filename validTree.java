/**
 * Two major points to care about:
 * @1 How to create a graph with int[][]
 * @2 How to judge a graph is tree or not? edges = n-1 ; graph is connected
 * @3 How to determine a graph is connected
 * */
import java.util.*;

public class validTree {
	public static boolean validTree(int n, int[][] edges) {
		if (n == 0)					return false;
		if (edges.length != n-1)	return false;
		
		Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);
		
		/**
		 * We want to create a queue, from number 0, add new neighbour to the queue
		 * Using Linked list to realize the queue, easy to add and delete
		 */
		Queue<Integer> queue = new LinkedList<>();
		/**
		 * Create a Set to record what we have added to the queue
		 * Make sure we are not adding a node to the queue twice
		 * So the set and Queue manipulation should come up together
		 * Use HashSet to implement Set
		 * */
		Set<Integer> hash = new HashSet<>();
		
		/**
		 * Use a Integer to record whether a node has been visited, and compare with n
		 * visited will == n if the graph is connected
		 * */
		int visited = 0;
		
		queue.offer(0);
		hash.add(0);
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			visited++;
			Set<Integer> neighbours = graph.get(cur);
			for (int neighbour: neighbours) {
				if (hash.contains(neighbour))	continue;
				queue.offer(neighbour);
				hash.add(neighbour);
			}
		}
		
		return visited == n;
	}
	
	//Create the graph with adjacent table
	private static Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
		Map<Integer, Set<Integer>> graph = new HashMap<>(); 	//Pay attention to how to initialize, HashMap is a way to implement the Map
		for (int i = 0; i < n; i++) {
			graph.put(i, new HashSet<Integer>());
		}
		
		for (int i = 0; i < edges.length; i++) {				//Add each other as neighbour
			int u = edges[i][0];
			int v = edges[i][1];
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		return graph;
	}
	
	public static void main (String[] args) {
		int n = 5;
		int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
		System.out.println(validTree(n, edges));
	}
}
