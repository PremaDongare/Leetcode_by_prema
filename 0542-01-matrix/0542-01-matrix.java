class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int [][] dist = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        // initalize 
        for(int i=0; i<m; i++){
            for(int j =0; j<n; j++){
                if(mat[i][j]==0){
                    dist[i][j]=0;
                    q.offer(new int []{i,j}); // all 0's in queue
                }else{
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // direction
        int[][] dirs= {{1,0}, {-1,0},{0,1},{0,-1}};

        //BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    if (dist[nr][nc] > dist[r][c] + 1) {
                        dist[nr][nc] = dist[r][c] + 1;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return dist;
    }
}