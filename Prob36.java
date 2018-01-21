import java.util.HashSet;

public class Prob36 {
	
	public static void main(String[] args) {
		char[][] testCase = {{'.', '8', '7', '6', '5', '4', '3', '2', '1'}, {'2', '.', '.', '.', '.', '.', '.', '.', '.'}, {'3', '.', '.', '.', '.', '.', '.', '.', '.'}, {'4', '.', '.', '.', '.', '.', '.', '.', '.'}, {'5', '.', '.', '.', '.', '.', '.', '.', '.'}, {'6', '.', '.', '.', '.', '.', '.', '.', '.'}, {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, {'8', '.', '.', '.', '.', '.', '.', '.', '.'}, {'9', '.', '.', '.', '.', '.', '.', '.', '.'}};
		System.out.println(validSudoku(testCase));
	}
	
	/* Valid Sudoku*/
	public static boolean validSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			HashSet<Character> rows = new HashSet<Character>();
			HashSet<Character> columns = new HashSet<Character>();
			HashSet<Character> cubes = new HashSet<Character>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !rows.add(board[i][j]))    //Had problem here, I was comparing char to ".", where it suppose to be '.', can't compare char with string
					return false;
				
				if (board[j][i] != '.' && !columns.add(board[j][i]))
					return false;
				int row = j / 3 + 3 * (i / 3);
				int col = j % 3 + 3 * (i % 3);
				if (board[row][col] != '.' && !cubes.add(board[row][col]))
					return false;
			}
		}
		
		return true;
	}
	
}
