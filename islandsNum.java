import java.util.LinkedList;
import java.util.Queue;

public class islandsNum {
	
	/**
	 * Had problem in claiming this class
	 * Use public before the function name
	 * Use this when doing the initiation
	 * */
	static class cordinates {
		int x, y;
		public cordinates(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	/**
	 * Could using DFS, but better BFS to avoid too deep traversal
	 * */
	public static int numsIslands (boolean[][] grid) {
		/**
		 * Have to pay attention to check the grid
		 * Don't put it after the n, m claim
		 * Because if grid == 0, there is no grid[0], so we will get outOfBound error
		 * */
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		
		int n = grid.length;
		int m = grid[0].length;
		
		int islands = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j]) {
					markAsVisited(grid, i, j);
					islands++;
				}
			}
		}
		
		return islands;
	}
	
	public static void markAsVisited (boolean[][]grid, int x, int y) {
		int[] deltx = {0, 0, 1, -1};
		int[] delty = {1, -1, 0, 0};
		
		Queue<cordinates> plots = new LinkedList<>();
		plots.offer(new cordinates(x, y));
		while (!plots.isEmpty()) {
			cordinates cur = plots.poll();
			for (int i = 0; i < 4; i++) {
				cordinates newDir = new cordinates(cur.x + deltx[i], cur.y + delty[i]);

				if (!checkBound(grid, newDir.x, newDir.y))
					continue;
				
				if (grid[newDir.x][newDir.y]) {
					grid[newDir.x][newDir.y] = false;
					plots.offer(newDir);
				}
			}
		}
	}
	
	public static boolean checkBound (boolean[][]grid, int x, int y) {
		if (x >= grid.length || x < 0)	return false;
		if (y >= grid[0].length || y < 0)	return false;
		return true;
	}
	
	public static void main (String[] args) {
		boolean[][] grid = {{true, true, false, false, false},
							{false, true, false, false, true},
							{false, false, false, true, true},
							{false, false, false, false, false},
							{false, false, false, false, true}};
		boolean[][] grid2 = {};
		int islandsNum = numsIslands(grid2);
		System.out.println(islandsNum);
	}
}
