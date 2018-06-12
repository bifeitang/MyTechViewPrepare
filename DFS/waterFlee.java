package DFS;

import java.util.ArrayList;
import java.util.List;


// This is the way to solve the problem recursively
public class waterFlee {
	
	public static StringBuilder waterTest (int[][] matrix, int R, int L) {
		
		List<Integer[]> wayOut = new ArrayList<>();
		StringBuilder isedge = new StringBuilder("No");
		Integer[] curpos = {R, L};
		
		wayOut.add(curpos);
		
		dfsHelper(matrix, curpos, wayOut, isedge);
		
		return isedge;
	}
	
	public static void dfsHelper(int[][] matrix,
								 Integer[] curpos,
								 List<Integer[]> wayOut,
								 StringBuilder isedge) {
		
		int edge = matrix.length;
		if (curpos[0] == edge - 1 || curpos[1] == edge - 1 || curpos[0] == 0 || curpos[1] == 0) {
			System.out.println("reach here and set isedge to true");
			isedge.replace(0, isedge.length(), "Yes");
			return;
		}
		
		int[] deltX = {1, 0, 0, -1};
		int[] deltY = {0, 1, -1, 0};
		
		/**
		 * better to give some example here:
		 * say 4 -> 2/3  -> 1 edge **/
		for(int i = 0; i < 4; i++) {
			// 坐标变换数组
			if (matrix[curpos[0] + deltX[i]][curpos[1] + deltY[i]] < matrix[curpos[0]][curpos[1]]) {
				Integer[] newPos = {curpos[0] + deltX[i], curpos[1] + deltY[i]};
				wayOut.add(newPos);
				dfsHelper(matrix, newPos, wayOut, isedge);
			}
		}
		
		if (isedge.toString().matches("Yes"))	{
			return;
		} else {
			// Now comes to the dead end, return
			wayOut.remove(wayOut.size() -1);
			return;
		}
		
	}
	
	public static void main (String[] args) {
		int[][] matrix = {{10,18,13},{9,7,8},{1,11,3}};
		
		StringBuilder result = waterTest(matrix, 1, 1);
		System.out.println(result.toString());
	}
}
