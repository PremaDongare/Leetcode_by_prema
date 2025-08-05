class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        boolean [][]t = new boolean[n][n];
        int count =0;
        // length of substring start with 1
        for(int L=1; L<=n; L++){
        for(int i=0; i+L<=n; i++){
            int j=i+L-1;

            // for 1 length single character
            if(i==j){
                t[i][i]=true;
            }else if (i+1 == j){
               t[i][j] = (s.charAt(i) == s.charAt(j));  // string of two character
            }else{
                t[i][j] = (s.charAt(i) == s.charAt(j) && t[i+1][j-1]);
            }

            if(t[i][j]){
                count ++;
            }
        }
        }
        return count;
    }
}