
// recursion-memoisation  o(n^2) sc o(n)

class Solution {

    Boolean[] dp; 
    public boolean canJump(int[] nums) {
        dp =  new Boolean[nums.length];
        return  canReach(0,nums);
    }

        private boolean canReach(int index, int[]nums){
            //if we cross last index
            if(index >= nums.length-1){
                return true;
            }
              // if we get zero
            if(nums[index] == 0){
                return false;
            }

            //if value present in dp
            if(dp[index] != null){
                return dp[index];
            }

            // all possible jumb
            for(int jump= 1; jump<= nums[index];jump++){
                if(canReach(index+jump,nums)){
                    dp[index]=true; // store result
                    return true;
                }
            }
            dp[index] = false; 
            return false;
        }
        
    
}