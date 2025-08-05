// for dp

class Solution {
    public String longestPalindrome(String s) {
      int n = s.length();
      int max =0;
      int index=0;

      boolean[][] t= new boolean[n][n];

      // for  single character
      for(int i=0; i<n;i++){
        t[i][i] = true;
        max =1;
        index=i;
      } 

      // check for 2
      for(int i=0; i<n-1; i++){
        if(s.charAt(i) == s.charAt(i+1)){
            t[i][i+1]=true;
            max=2;
            index=i;
        }
      }
      // for mor than 2 

      for(int L =3; L<=n ; L++){
        for(int i=0; i<n-L+1;i++){
            int j=i+L-1;

            if(s.charAt(i) == s.charAt(j) && t[i+1][j-1]){
                t[i][j] = true;
                if(j-i+1 >max){
                    max=j-i+1;
                    index =i;
                }
            }
        }
      }
      return s.substring(index, index+max);
    }
}