class Solution {
    public int longestOnes(int[] n, int k) {
        int left =0,  right =0;
        int zeroCount=0;
        int maxLength=0;

        while(right < n.length){
            if(n[right] == 0){
                 zeroCount++;
            }
            while( zeroCount>k){
                if(n[left] == 0){
                     zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }

        return maxLength;
    }
}