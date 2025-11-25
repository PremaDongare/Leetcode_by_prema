class Solution {
    private void swap(int[]nums, int x, int y){
        int temp = nums[x];
        nums[x]= nums[y];
        nums[y]=temp;
    }

    public int partation(int []nums, int L, int R){
        int p=nums[L];
        int i = L+1;
        int j = R;

        while(i<=j){
            if(nums[i]<p && nums[j]>p){
                swap(nums, i,j);
                i++;
                j--;
            }
            if(nums[i]>=p){
                i++;
            }
            if(nums[j]<=p){
                j--;
            }
        }
        swap(nums,L,j);
        return j;// p is at jth index
    }
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int L=0;
        int R = n-1;

        int pivot=0;

        while(true){
            pivot = partation(nums,L,R);
            if(pivot == k-1){
                break;
            }
            else if(pivot > k-1){
                R=pivot-1;
            }else{
                L=pivot+1;
            }
        }
        return nums[pivot];
    }
}