package DFS;

import java.util.LinkedList;
import java.util.Queue;

public class minDepth {
	
	public class TreeNode {
		public int val;
		public TreeNode left = null;
		public TreeNode right = null;
		public TreeNode (int val) {
			this.val = val;
		}
	}
	
	// Key: find leaf while doing BFS
	public int findMinDepth (TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int depth = 0;
		
		Queue<TreeNode> helper = new LinkedList<>();
		helper.offer(root);
		
		while (!helper.isEmpty()) {
			depth++;
			int size = helper.size();
			
			// condition of entering for loop: size != 0
			for (int i = 0; i < size; i++) {
				TreeNode curNode = helper.poll();
				if (curNode.left == null && curNode.right == null) {
					return depth;
				}
				if(curNode.left != null) {
					helper.offer(curNode.left);
				}
				if(curNode.right != null) {
					helper.offer(curNode.right);
				}
			}
		}
		
		return depth;
	}
	
	// Using recursion: cur min is the min of left right + 1, this is bottom up
	public int findMinRecursion(TreeNode root) {
		return helper(root);
	}
	
	public int helper(TreeNode curNode) {
		// Again making mistake here, the terminal condition is leaf node!
		if (curNode.left == null && curNode.right == null) {
			return 1;
		}
		
		// We can change this judge to return the max value while encounter the null point
		if (curNode.left == null) {
			return helper(curNode.right) + 1;
		}
		
		if (curNode.right == null) {
			return helper(curNode.left) + 1;
		}
		
		return Math.min(helper(curNode.left), helper(curNode.right)) + 1;
	}
}
