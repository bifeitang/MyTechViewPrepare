/**
 * LeetCode 297 */
import java.util.LinkedList;
import java.util.Queue;

public class binaryTreeSeralization {
	public class TreeNode {
		public int val;
		public TreeNode left, right;
		public TreeNode (int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}
	
	public String seralization (TreeNode root) {
		if (root == null)	return "";
		
		Queue<TreeNode> queue = new LinkedList<>();
		StringBuilder results = new StringBuilder();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur == null) {
				results.append("n ");
				continue;
			}
			results.append(cur.val + " ");
			queue.offer(cur.left);
			queue.offer(cur.right);
		}
		
		return results.toString();
	}
	
	public TreeNode deseralization (String data) {
		if (data == "")	return null;
		Queue<TreeNode> queue = new LinkedList<>();
		String[] values = data.split(" ");
		TreeNode root = new TreeNode(Integer.parseInt(values[0])); //Remember how to deal with string to integer
		queue.offer(root);
		for (int i = 1; i < values.length; i++) {                   //Start point is wrong, suppose to be 1, instead of 0
			TreeNode cur = queue.poll();
			if (!values[i].equals("n")) {
				TreeNode left = new TreeNode(Integer.parseInt(values[i]));   //We can't directly initialize the TreeNode
				cur.left = left;
				queue.offer(left);
			}
			
			
			if (!values[++i].equals("n")) {
				TreeNode right = new TreeNode (Integer.parseInt(values[i]));
				cur.right = right;
				queue.offer(right);
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
	
	}
}
