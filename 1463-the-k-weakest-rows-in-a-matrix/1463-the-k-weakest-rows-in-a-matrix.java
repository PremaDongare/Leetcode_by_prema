class Solution {
    static class Row implements Comparable<Row>{
        int soldiers;
        int idx;
        public Row(int soldiers, int idx){
            this.soldiers=soldiers;
            this.idx=idx;
        }
        @Override
        public int compareTo(Row r2){
            if(this.soldiers == r2.soldiers){
                return this.idx-r2.idx;
            }else{
                return this.soldiers-r2.soldiers;
            }
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int m= mat.length, n=mat[0].length;
        PriorityQueue<Row> pq = new PriorityQueue<>();

        for(int i=0; i<m;i++){
            int count=0;
            for(int j=0; j<n; j++){
                count += mat[i][j] == 1?1:0;
            }
            pq.add(new Row(count,i));
        }
          int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.remove().idx;
        }
        return result;
    }

    
}