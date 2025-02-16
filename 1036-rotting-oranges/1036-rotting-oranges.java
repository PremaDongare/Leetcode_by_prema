import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        // Get the dimensions of the grid
        int n = grid.length;
        int m = grid[0].length;

        // Create a queue to store the rotten oranges
        Queue<int[]> q = new LinkedList<>();

        // Create a visited array to keep track of rotten oranges
        int[][] vis = new int[n][m];

        // Initialize the count of fresh oranges
        int cntFresh = 0;

        // Iterate through the grid to find rotten oranges and fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If the cell contains a rotten orange, add it to the queue and mark it in the visited array
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j, 0}); // Store the row, column, and time in the queue
                    vis[i][j] = 2;
                }
                // If the cell contains a fresh orange, mark it in the visited array
                else if (grid[i][j] == 1) {
                    vis[i][j] = 0;
                    cntFresh++;
                }
            }
        }

        // Initialize the time and the count of rotten oranges
        int tm = 0;
        int cnt = 0;

        // Define the possible row and column changes to check neighboring cells
        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, 1, 0, -1};

        // Continue until there are no more rotten oranges in the queue
        while (!q.isEmpty()) {
            int size = q.size(); // Get the current size of the queue

            // Process all rotten oranges in the current queue
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll(); // Remove and get the next rotten orange
                int r = cell[0]; // Get the row of the rotten orange
                int c = cell[1]; // Get the column of the rotten orange
                int t = cell[2]; // Get the time of the rotten orange

                // Update the maximum time if necessary
                tm = Math.max(tm, t);

                // Check all neighboring cells
                for (int j = 0; j < 4; j++) {
                    int nrow = r + drow[j]; // Calculate the row of the neighboring cell
                    int ncol = c + dcol[j]; // Calculate the column of the neighboring cell

                    // Check if the neighboring cell is within the grid, has not been visited, and contains a fresh orange
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                            vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                        // Add the neighboring cell to the queue as a rotten orange and mark it in the visited array
                        q.add(new int[]{nrow, ncol, t + 1});
                        vis[nrow][ncol] = 2;
                        cnt++;
                    }
                }
            }
        }

        // If not all oranges have rotted, return -1
        if (cnt != cntFresh) return -1;

        // Return the maximum time taken for all oranges to rot
        return tm;
    }
}