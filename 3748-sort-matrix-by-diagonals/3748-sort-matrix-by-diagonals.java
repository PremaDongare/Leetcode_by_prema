class Solution {

    int n;
    private void sortDiagonal(int r, int c, int[][] grid, boolean asc){
        List<Integer> vec = new ArrayList<>();
        int i=r, j=c;
        while(i<n && j<n){
            vec.add(grid[i][j]);
            i++;
            j++;

        }

        if(asc){
            Collections.sort(vec);
        }else{
            vec.sort(Collections.reverseOrder());
        }

        i =r;
        j=c;
        for(int val:vec){
            grid[i][j]=val;
            i++;
            j++;
        }

    }
    public int[][] sortMatrix(int[][] grid) {
        n=grid.length;

        // Bottom left
        for(int row=0; row<n; row++){
            sortDiagonal(row,0,grid,false);
        }
        //top-right
        for(int col=1; col<n; col++){
            sortDiagonal(0,col,grid,true);
        }

        return grid;
    }
}