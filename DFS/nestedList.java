package DFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */


public class nestedList {
	
	public interface NestedInteger {
		public boolean isInteger();
		public Integer getInteger();
		public List<NestedInteger> getList();
 	}

 	// Using recursion
	public int depthSum(List<NestedInteger> nestedList) {
		return helper(nestedList, 1);
	}
	
	public int helper (List<NestedInteger> nestedList, int depth) {
		if (nestedList == null || nestedList.size() == 0) {
			return 0;
		}
		
		int sum = 0;
		for (int i = 0; i < nestedList.size(); i++) {
			
			if (nestedList.get(i).isInteger()) {
				sum += nestedList.get(i).getInteger() * depth;
			} else {
				sum += helper(nestedList.get(i).getList(), depth + 1);
			}
		}
		
		return sum;
	}
	
	// Using non-recursion, the loop always use while with a stop condition
	public int depthLoopSum(List<NestedInteger> nestedList) {
		if (nestedList == null || nestedList.size() == 0) {
			return 0;
		}
		
		int sum = 0;
		
		// Say I have a Queue here
		Queue<NestedInteger> intQueue = new LinkedList<NestedInteger>();
		
		for (NestedInteger nestedInt : nestedList) {
			intQueue.offer(nestedInt);
		}
		
		// every level of the queue is a sum of all the Integer
		int depth = 0;
		while (!intQueue.isEmpty()) {
			int size = intQueue.size();
			depth++;
			for (int i = 0; i < size; i++) {
				NestedInteger nestedint = intQueue.poll();
				if (nestedint.isInteger()) {
					sum += nestedint.getInteger() * depth;
				} else {
					for (NestedInteger innerInt: nestedint.getList()) {
						intQueue.offer(innerInt);
					}
				}
			}
		}
		return sum;
	}
}
