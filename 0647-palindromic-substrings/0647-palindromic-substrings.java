class Solution {
       //using memorization
       int [][]t;
    public boolean check(String s, int i, int j){
        if(i>=j){
            return true;
        }
        if (t[i][j]!= -1){  // not visited
            return t[i][j]==1; // visited
        }
        if(s.charAt(i)==s.charAt(j)){
         boolean val= check(s, i+1, j-1);
         if(val==true){
         t[i][j] =1;
        }else{
            t[i][j]=0;
        }
        return val;
    }
    t[i][j]=0;
    return false;
    }
    public int countSubstrings(String s) {
       int n = s.length();
       t= new int[n][n];
       for(int[] row:t){
        Arrays.fill(row,-1);
       }
       int count =0;

       for(int i=0; i<n; i++){
        for(int j=i; j<n; j++){
            if(check(s,i,j)){
                count++;
            }
        }
       } 
       return count;
    }
}