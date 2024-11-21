import java.util.*;
public class sudoku {

	public static boolean isItSudokusudoku(int matrix[][]) {
		for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (matrix[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValidPlacement(matrix, num, row, col)) {
                            matrix[row][col] = num;

                            if (isItSudokusudoku(matrix)) {
                                return true;
                            } else {
                                matrix[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidPlacement(int[][] matrix, int num, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (matrix[row][i] == num || matrix[i][col] == num) {
                return false;
            }
        }

        int subGridRowStart = row - row % 3;
        int subGridColStart = col - col % 3;

        for (int i = subGridRowStart; i < subGridRowStart + 3; i++) {
            for (int j = subGridColStart; j < subGridColStart + 3; j++) {
                if (matrix[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            int tc = sc.nextInt();
            while (tc-- > 0) {
    
                int[][] matrix = new int[9][9];
    
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        matrix[i][j] = sc.nextInt();
                    }
                }
    
                boolean ans = sudoku.isItSudokusudoku(matrix);
    
                if (ans) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    

		// Write your code here.

	}
