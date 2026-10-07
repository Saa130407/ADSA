public class NQueen {
    private static int n;
    private static int[] board; // board[row] = column containing the queen

    public static void main(String[] args) {
        n = 8; // Change this to the board size you want
        board = new int[n + 1]; // Use rows and columns numbered from 1

        solve(1);
    }

    private static void solve(int row) {
        if (row > n) {
            printBoard();
            return;
        }

        for (int col = 1; col <= n; col++) {
            if (isSafe(row, col)) {
                board[row] = col;
                solve(row + 1);
                board[row] = 0;
            }
        }
    }

    private static boolean isSafe(int row, int col) {
        for (int i = 1; i < row; i++) {
            if (board[i] == col ||
                Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    private static void printBoard() {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print(board[row] == col ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}