class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // store in hashmap
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<m;i++){
            for(int j=0; j<n ; j++){
                int key=i+j;
               map.putIfAbsent(i+j, new ArrayList<>());
                map.get(i+j).add(mat[i][j]);
            }
        }
      List <Integer> resultList= new ArrayList<>();
      boolean flip = true;

      for(int k =0; k<=m+n-2; k++){
        List<Integer> diagonals = map.get(k);
        if(diagonals == null) continue;

        if(flip){
            Collections.reverse(diagonals);
        }
        resultList.addAll(diagonals);
        flip =!flip;
      }

         int [] result = new int[resultList.size()];
         for(int i=0; i<resultList.size();i++){
            result[i] = resultList.get(i);
         }
         return result;

    }
}