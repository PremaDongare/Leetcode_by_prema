class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int freshorange =0;
      // traverse the grid and add oranges = 2 in queue
        for (int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[] {i,j});
                }else if(grid[i][j]==1){
                    freshorange ++;
                }
            }
        }

       if(freshorange  == 0) return 0;
       int minutes =0;

       // direction
        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

       // bfs on queue
       while(!q.isEmpty()){
        int size = q.size();
        boolean rootted = false;

        // traverse oranges
        for (int i=0; i<size; i++){
            int[] cell=q.poll();
            int r = cell[0];
            int c = cell[1];

             // Check all 4 cells
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

            if(nr >=0 && nr<row && nc >=0 && nc<col && grid[nr][nc]==1){

                 grid[nr][nc]=2;
                q.offer(new int[]{nr, nc});
                        freshorange --;
                        rootted = true;
                    }
                }
            }

            // Increase time only if at least one orange rotted
            if (rootted) minutes++;
        }

        // Step 3: If fresh oranges remain, return -1
        return freshorange == 0 ? minutes : -1;
    }
}