class Solution {
    public int findMin(int[] nums) {
        int ans=Integer.MAX_VALUE;
        int low=0;
        int heigh = nums.length-1;


        while(low <= heigh){
            int mid = low +(heigh-low)/2;

            if(nums[low] <= nums[mid]){
                ans = Math.min(ans,nums[low]);
            
            // eliminate left

            low = mid+1;
        }else{
            ans = Math.min(ans, nums[mid]);

            heigh = mid-1;
        }
    }
    

return ans;
}
}