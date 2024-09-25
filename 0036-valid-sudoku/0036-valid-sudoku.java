class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Create sets for rows, columns, and sub-boxes
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Traverse the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') {
                    continue; // Skip empty cells
                }

                // Calculate box index
                int boxIndex = (i / 3) * 3 + j / 3;

                // Check if the number is already in the row, column, or box
                if (rows[i].contains(num) || cols[j].contains(num) || boxes[boxIndex].contains(num)) {
                    return false; // Invalid Sudoku
                }

                // Add number to the respective row, column, and box set
                rows[i].add(num);
                cols[j].add(num);
                boxes[boxIndex].add(num);
            }
        }

        return true; // Valid Sudoku
    }
}
