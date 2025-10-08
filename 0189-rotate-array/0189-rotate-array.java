class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k=k%n;
        int[] res = new int[n];
        int ind =0;
        for (int i=n-k; i<n; i++){
            res[ind++] = nums[i];
        }

        for(int j=0; j<n-k; j++){
            res[ind++]= nums[j];
        }
        for(int i=0; i<n; i++){
            nums[i] = res[i];
        }
    }
}