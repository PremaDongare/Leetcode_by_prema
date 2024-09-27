class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // If the current index is beyond the maximum reachable point, return false
            if (i > maxReach) {
                return false;
            }
            
            // Update the maximum point reachable from this index
            maxReach = Math.max(maxReach, i + nums[i]);
            
            // If the maximum point is beyond or equal to the last index, return true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        
        return false;  // If we exit the loop, it means we can't reach the last index
    }
}
