package DFS;

import java.util.ArrayList;
import java.util.List;

public class symmtricTree {
	
	public class TreeNode {
		public int value;
		public TreeNode left, right;
		public TreeNode (int val) {
			this.value = val;
			this.left = this.right = null;
		}
		
	}
	
	public boolean isSymmetric (TreeNode root) {
		if (root == null)	return true;
		
		// There's a simple logic behind which I didn't get:
		// left -> left = right -> right
		// left -> right = right -> left
		
		return treeHelper (root.left, root.right);
	}
	
	public boolean treeHelper(TreeNode left, TreeNode right) {
		// Here to remind the end of the tree
		if (left == null || right == null) {
			return left == right;
		}
		
		return (left.value == right.value) && treeHelper(left.left, right.right) && treeHelper(left.right, right.left);
	}
}
