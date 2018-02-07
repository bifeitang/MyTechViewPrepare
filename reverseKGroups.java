public class reverseKGroups {
	static class ListNode {
		int val;
		ListNode next;
		ListNode (int x) {val = x;}
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k <= 1)	return head;
		//Use dummy node who always points to the first node
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		head = dummy;
		while (head != null) {
			head = reverseKnodes(head, k);
		}
		
		return dummy.next;
	}
	
	/**
	 * head -> n1 -> n2 -> ... -> nk -> nk+1
	 * head -> nk -> ... -> n2 -> n1 -> nk+1
	 * Input: List of Nodes with head
	 * Return: n1, the head for next nk
	 * */
	public ListNode reverseKnodes(ListNode prev, int k) {
		//First count if the left nodes > k
		ListNode head = prev.next;
		ListNode next = head;
		for (int i = 0; i < k; i++) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		
		return next;
	}
}
