class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int oddCount = 0;
        int result = 0;
        int Prevcount =0;

        int i=0, j=0;

        while(j<n){
            if(nums[j] %2 != 0){
                oddCount++;
                Prevcount=0; // reset
            }

         while(oddCount == k){
            Prevcount++;

            if(i<n && nums[i] % 2 == 1){
                oddCount --;

            }
            i++;
         }

         result += Prevcount;
         j++;
        }
        return result;
    }
}