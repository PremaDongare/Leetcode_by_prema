class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        // int[] best = null;
        double bestdiag = -1.0;
        int bestarea=0;

        for(int[] d: dimensions){
            int w=d[0],h=d[1];
            long diagsqu= w*w + h*h;
            int area = w*h;

            if(diagsqu > bestdiag || diagsqu == bestdiag && area > bestarea){
                bestdiag = diagsqu;
                bestarea = area;
                // best = d;
            } 
        }
        return  bestarea;
        // best[0] * best[1];
    }
}