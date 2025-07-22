class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int oddCount = 0;
        int result = 0;
        int count =0;

        int i=0, j=0;

        while(j<n){
            if(nums[j] %2 != 0){
                oddCount++;
                count=0; // reset
            }

         while(oddCount == k){
            count++;

            if(i<n && nums[i] % 2 == 1){
                oddCount --;

            }
            i++;
         }

         result += count;
         j++;
        }
        return result;
    }
}