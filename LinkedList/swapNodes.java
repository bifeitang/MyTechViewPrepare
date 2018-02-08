package LinkedList;

public class swapNodes {
	public ListNode swapNodes(ListNode head, int v1, int v2) {
		if (head == null || v1 == v2)   return head;
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode prev1 = null, prev2 = null;
		ListNode curr = dummy;
		
		while (curr.next != null) {
			if (curr.next.val == v1) {
				prev1 = curr;
			} else if (curr.next.val == v2) {
				prev2 = curr;
			}
			curr = curr.next;
		}
		
		if (prev1 == null || prev2 == null) {
			return head;
		}
		
		if (prev2.next == prev1) {
			ListNode temp = prev1;
			prev1 = prev2;
			prev2 = temp;
		}
		
		ListNode node1 = prev1.next;
		ListNode node2 = prev2.next;
		ListNode next2 = node2.next;
		/**
		 * prev1 -> node1 -> node2 -> next2
		 * prev1 -> node2 & node1 -> node2
		 * node2 -> node1
		 * node1 -> next2
		 * */
		if (node1 == prev2) {
			prev1.next = node2;
			node2.next = node1;
			node1.next = next2;
		} else {
			prev1.next = node2;
			node2.next = node1.next;
			
			prev2.next = node1;
			node1.next = next2;
		}
		
		return dummy.next;
	}
}
