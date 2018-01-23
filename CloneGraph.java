import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.util.*;

public class CloneGraph {
	class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;
		UndirectedGraphNode (int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}
	
	public UndirectedGraphNode cloneGraph (UndirectedGraphNode node) {
		if (node == null)   return node;		// Had problem here, have to check
		
		//Get all nodes in the graph
		ArrayList<UndirectedGraphNode> allNodes = getAllNodes(node);
		
		//Better using hashMap here to map new to old, had problem without using hashMap
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map= new HashMap<>();
		for (UndirectedGraphNode cur: allNodes) {
			map.put(cur, new UndirectedGraphNode(cur.label));
		}
		
		for (UndirectedGraphNode cur: allNodes) {
			ArrayList<UndirectedGraphNode> neighbors = new ArrayList<>();
			for (UndirectedGraphNode neighbor: cur.neighbors) {
				neighbors.add(map.get(neighbor));
				//neighbors.add(neighbor);			//Had problem here, I was connecting the old map's neighbor with new map
			}
			map.get(cur).neighbors = neighbors;
		}
		
		return map.get(node);
	}
	
	public static ArrayList<UndirectedGraphNode> getAllNodes (UndirectedGraphNode node) {
		ArrayList<UndirectedGraphNode> allNodes = new ArrayList<>();
		
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		Set<UndirectedGraphNode> hash = new HashSet<>();
		
		queue.offer(node);
		hash.add(node);
		
		while(!queue.isEmpty()) {
			UndirectedGraphNode cur= queue.poll();
			allNodes.add(cur);
			for (UndirectedGraphNode neighbour: cur.neighbors) {
				if (hash.contains(neighbour))	continue;
				queue.offer(neighbour);
				hash.add(neighbour);
			}
		}
		return new ArrayList<UndirectedGraphNode>(hash);
	}
}
