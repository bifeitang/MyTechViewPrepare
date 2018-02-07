public class reverseLinkedListII {
	static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			val = x;
			next = null;
	 }
	}
	
	static public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null || m <= 0 || n <= 0 || (m-n) <= 1) {
			return head;
		}
		ListNode start = head, end = head;
		int counter = 1;
		while(counter != m-1) {
			start = start.next;
			end = end.next;
			counter++;
		}
		while(counter != n) {
			end = end.next;
			counter++;
		}
		ListNode header = start;
		start = start.next;
		header.next = end;
		ListNode prev = end.next;
		while(start != end) {
			ListNode temp = start.next;
			start.next = prev;
			prev = start;
			start = temp;
		}
		return head;
	}
	
	static void main (String[] args) {
		int[] nodeValues = {3760,2881,7595,3904,5069,4421,8560,8879,8488,5040,5792,56,1007,2270,3403,6062};
		ListNode[] nodes = new ListNode[nodeValues.length];
		for (int i = 0; i < nodeValues.length - 1; i ++) {
			nodes[i].val = nodeValues[i];
			nodes[i].next = nodes[i+1];
		}
		nodes[nodeValues.length - 1].val= nodeValues[nodeValues.length-1];
	}
}
