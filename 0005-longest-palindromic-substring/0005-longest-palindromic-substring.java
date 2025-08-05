class Solution {
      int [][]t;
    public String longestPalindrome(String s) {
        int n = s.length();
        int Max= Integer.MIN_VALUE;
        int start = 0; // help while calculating length

        // initialize t with 0 means not yet compute 
        t= new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(t[i],-1);
        }

        //now main loop
        for (int i=0; i<n; i++){
            for (int j=i; j<n; j++){

                // if it is palindrom and length is also greater that max
                if(solve(s,i,j) && j-i+1>Max){
                    start =i;
                    Max = j-i+1;
                }
            }
        }
         return s.substring(start, start+Max);
    }

    // function to check if the str is palin
    private boolean solve(String s, int l , int r){
        if (l>=r){
            return true;
        }
        // if alredy compu return the store result

        if (t[l][r] != -1){
             return t[l][r] == 1; // is palindrom
        }

        // palind logic
        if(s.charAt(l) == s.charAt(r)){
            t[l][r] = solve(s, l+1, r-1) ?1:0;
        }else{
            // if char not match 
            t[l][r]=0; //not a palindrom
        }

        return t[l][r]==1;
    }
}