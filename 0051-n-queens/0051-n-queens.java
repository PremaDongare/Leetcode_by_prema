class Solution {
    public boolean isSafe(char[][] board, int row, int col, int n) {
        // Check left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        // Check right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        // Check column (vertical)
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        
        return true;
    }

    public void nQueens(char[][] board, int row, int n, List<List<String>> ans) {
        if (row == n) {
            // Add the current board configuration to the result
            List<String> current = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                current.add(new String(board[i]));
            }
            ans.add(current);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q'; // Place a queen
                nQueens(board, row + 1, n, ans); // Recurse for next row
                board[row][col] = '.'; // Backtrack and remove the queen
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();

        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // Start the backtracking
        nQueens(board, 0, n, ans);
        return ans;
    }
}
