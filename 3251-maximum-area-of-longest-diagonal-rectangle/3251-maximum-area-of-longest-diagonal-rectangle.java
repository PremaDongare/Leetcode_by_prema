class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int[] best = null;
        double bestdiag = -1.0;
        long bestarea=-1;

        for(int[] d: dimensions){
            long w=d[0],h=d[1];
            long diagsqu= w*w + h*h;
            long area = w*h;

            if(diagsqu > bestdiag || diagsqu == bestdiag && area > bestarea){
                bestdiag = diagsqu;
                bestarea = area;
                best = d;
            } 
        }
        return best[0] * best[1];
    }
}