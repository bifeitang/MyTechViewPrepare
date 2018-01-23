import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class topologySort {
	class directedGraphNode {
		int label;
		ArrayList<directedGraphNode> neighbors;
		directedGraphNode (int x) {
			label = x;
			neighbors = new ArrayList<directedGraphNode>();
		}
	}
	
	public ArrayList<directedGraphNode> topoSort(ArrayList<directedGraphNode> graph) {
		ArrayList<directedGraphNode> results = new ArrayList<directedGraphNode>();
		HashMap<directedGraphNode, Integer> map = new HashMap<>();
		
		for (directedGraphNode node: graph) {
			for (directedGraphNode neighbor: node.neighbors) {
				if (map.containsKey(neighbor)) {
					map.put(neighbor, map.get(neighbor) + 1);
				} else {
					map.put(neighbor, 1);
				}
			}
		}
		
		Queue<directedGraphNode> q = new LinkedList<directedGraphNode>();
		for (directedGraphNode node : graph) {
			if (!map.containsKey(node)) {
				q.offer(node);
				results.add(node);
			}
		}
		
		while (!q.isEmpty()) {
			directedGraphNode node = q.poll();
			for (directedGraphNode n : node.neighbors) {
				map.put(n, map.get(n) - 1);
				if (map.get(n) == 0) {
					results.add(n);
					q.offer(n);
				}
			}
		}
		
		return results;
	}
}
