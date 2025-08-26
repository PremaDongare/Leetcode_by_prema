class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int [] sorted = nums.clone(); //copy and sort
        Arrays.sort(sorted);
        for(int r=0; r<n; r++ ){
            boolean isSorted = true;
            for (int i=0; i<n; i++){
                // check
                if (sorted[i] != nums[(i+r)%n]){
                    isSorted =false;
                    break;
                }
            }
            if(isSorted){
                return true;
            }
        }
        return false;
    }
}