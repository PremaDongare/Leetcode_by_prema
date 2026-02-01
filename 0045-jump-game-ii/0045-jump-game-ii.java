class Solution {
    int dp[];
    public int jump(int[] nums) {
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(0,nums);
    }
    private int solve(int i, int[]nums){

        if(i>=nums.length-1)return 0;
        if(nums[i]==0) return 10000000;

        if(dp[i] != -1)return dp[i];

        int minjump=10000000;
        for(int jump=1; jump<=nums[i];jump++){
            minjump=Math.min(minjump,1+solve(i+jump,nums));
        }

        return dp[i]= minjump;
    }
}