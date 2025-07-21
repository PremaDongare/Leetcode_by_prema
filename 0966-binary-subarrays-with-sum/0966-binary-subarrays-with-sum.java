class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int prefixzero=0;
        int windowsum =0;
        int count =0;
        int i=0, j=0;

        while(j<nums.length){
            windowsum += nums[j];

            while(i<j && (nums[i] == 0 || windowsum > goal)){
                if(nums[i] == 1){
                    prefixzero=0;
                }
                else{
                    prefixzero +=1;
                }

                windowsum -= nums[i];
                i++;
            }
            if(windowsum == goal){
                count+=1+prefixzero;
            }
            j++;
        }
        return count;
    }
}