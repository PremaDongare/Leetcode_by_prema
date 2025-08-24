class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, zero = 0, maxlength = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zero++;
            }

            // shrink 
            while (zero > 1) {
                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }

           
            maxlength = Math.max(maxlength, right - left);
        }

        return maxlength;
    }
}
