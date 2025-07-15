class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxcount =0;
        
        for(int i=0; i<n; i++){
            int zero =0;
        for(int j=i; j<n; j++){
            if(nums[j] == 0) zero++;
            if(zero>k) break;
              maxcount = Math.max(maxcount, j -i+1);
        }
      
        }

        return maxcount;
    }

    
}