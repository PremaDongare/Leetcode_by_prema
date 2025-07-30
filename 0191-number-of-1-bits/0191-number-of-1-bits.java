class Solution {
    public int hammingWeight(int n) {
        int count =0;
        while(n!=0){
            n=n&(n-1); // turn off the 1 to 0 
            count++;
        }

        return count;
    }
}