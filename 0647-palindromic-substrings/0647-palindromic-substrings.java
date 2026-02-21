
// Expand around center 
//Tc = O(n^2)
//Sc= O(1)

class Solution {

     int count =0;

    private void check(String s, int i, int j, int n){
        while(i>=0 && j<n && s.charAt(i) == s.charAt(j)){
            count ++;
// expand from center
            i--;
            j++;         
        }
    }
    public int countSubstrings(String s) {
        int n = s.length();
         count =0;

        // consider every single character as a center .
              for(int i=0; i<n; i++){
                check(s,i,i,n); // odd
                check(s, i, i+1, n);//even
              }
              return count;

    }
}