class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int [] sorted = new  int[n];
        // for rottated arr
        for(int r=0; r<n; r++){
        // for i
        int idx=0;
        for(int i=r; i<n; i++){   // if r=3 then i =3 to end (element taken )
        
          sorted[idx]=nums[i];
          idx ++;

        }

        // loop for remening elements
        for(int i=0; i<r; i++){
            sorted[idx]= nums[i];
            idx++;
        }
        // now check if the arry is sorted
        boolean isSorted= true;
        for(int i=0; i<n-1; i++){
            if(sorted[i] > sorted[i+1]){
                isSorted=false;
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