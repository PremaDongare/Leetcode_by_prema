//dp tabulation  

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        boolean [] t = new boolean[n];
        //if t = true means you reach that index

        // we are alredy on ind=0;
        t[0]= true;
        for(int i=0; i<n; i++){
            for(int j =i-1; j>=0; j--){
                // check we can jump from j to i and j is reachable
                if(t[j] && j+nums[j]>=i){
                    t[i]=true;
                    break;
                }
            }
        }
        return t[n-1];
    }
}