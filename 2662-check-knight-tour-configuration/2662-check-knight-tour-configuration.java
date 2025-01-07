class Solution {
    private boolean isValid(int[][] grid, int r, int c, int n, int expVal){
             if(r<0 || c<0 || r>= n || c>=n || grid[r][c] != expVal){
                return false;
             }
             if(expVal == n*n-1){
                return true;
             }

             // 8 possible moves
             // Check all 8 possible knight moves
        return isValid(grid, r - 2, c + 1, n, expVal + 1) ||
               isValid(grid, r - 1, c + 2, n, expVal + 1) ||
               isValid(grid, r + 1, c + 2, n, expVal + 1) ||
               isValid(grid, r + 2, c + 1, n, expVal + 1) ||
               isValid(grid, r + 2, c - 1, n, expVal + 1) ||
               isValid(grid, r + 1, c - 2, n, expVal + 1) ||
               isValid(grid, r - 1, c - 2, n, expVal + 1) ||
               isValid(grid, r - 2, c - 1, n, expVal + 1);


             
    }

    public boolean checkValidGrid(int[][] grid) {
        return isValid(grid, 0,0, grid.length,0);
        
    }
}