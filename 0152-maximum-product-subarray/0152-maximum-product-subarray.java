class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int leftpro=1, rightpro=1;
        int max =nums[0];

        for(int i=0; i<n; i++){
         leftpro=(leftpro == 0?1:leftpro) * nums[i];
         rightpro=(rightpro == 0?1:rightpro) *nums[n-1-i];

         max= Math.max(max,Math.max(leftpro, rightpro));
        }
        return max;
    }
}