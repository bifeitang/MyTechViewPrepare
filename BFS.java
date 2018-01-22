import java.util.*;

public class BFS {
	public class TreeNode {
		public TreeNode left, right;
		public int val;
		public TreeNode (int val) {
			this.val = val;
			this.left = this.right = null;
		}
		
	}
	
	public List<List<Integer>> levelOrder (TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) 	return result;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {			//Pay attention to this part, have special function to see whether its null
			int size = queue.size();
			ArrayList<Integer> curLevel = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				curLevel.add(cur.val);
				if (cur.left != null)	queue.offer(cur.left);
				if (cur.right != null)	queue.offer(cur.right);
			}
			result.add(curLevel);
		}
		
		return result;
	}
	
	public static void main (String[] args) {
		//TreeNode test = new TreeNode(5); !!!! Have problem here, how to use the data structure
		//System.out.println(test);
	}
}
