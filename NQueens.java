import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public static List<List<String>> solveNQueens (int n) {
		List<List<String>>	results = new ArrayList<>();
		if (n <= 0)		return results;
		
		helper(n, results, new ArrayList<Integer>());
		return results;
	}
	
	/**
	 * @col: represent the column we put Queen to
	 * @n: Size of the chessboard
	 * @results: the final result we return
	 * */
	//1. Goal: find proper position when adding a new Queen
	private static void helper (int n,
								List<List<String>> results,
								List<Integer> col) {
		//2. Exit: when cols == n, add to the results
		if (col.size() == n) {
			List<String> solution = chessConverter (col);
			results.add(solution);
			return;
		}
		//3. Loop:
		for (int i = 0; i < n; i++) {
			if (!isValidPos(col, i))	continue;
			col.add(i);
			helper(n, results, col);
			col.remove(col.size() - 1);
		}
	}
	
	private static boolean isValidPos (List<Integer> col, int next) {
		if (col.contains(next))		return false;
		for (int row = 0; row < col.size(); row ++) {
			if ((col.get(row) + row) == next + col.size()){
				return false;
			}
			
			if (col.get(row) - row == next - col.size()) {		//Had logic problem here, I was adding abs to it, which return a lot of false (false)
				return false;
			}
		}
		return true;
	}
	
	private static List<String> chessConverter (List<Integer> col) {
		List<String> solution = new ArrayList<>();
		for (Integer num: col) {
			String row = new String();
			for (int i = 0; i < num; i++) {
				row = row + ".";
			}
			row = row + "Q";
			for (int i = num + 1; i < col.size(); i++) {
				row = row + ".";
			}
			solution.add(row);
		}
		return solution;
	}
	
	public static void main (String[] args) {
		System.out.println(solveNQueens(4));
	}
}
