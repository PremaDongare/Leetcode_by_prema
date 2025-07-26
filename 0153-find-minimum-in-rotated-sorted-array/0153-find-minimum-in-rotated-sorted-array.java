class Solution {
    public int findMin(int[] nums) {
        int low=0, height=nums.length-1;
        while(low<=height){
            int mid = low+(height-low)/2;

            if(nums[height]<=nums[mid]){

                low = mid+1;
            }else{
                height=mid;
            }
        }
        return nums[height];
    }
}