class Solution {
    public int findKthLargest(int[] nums, int k) {
        // min heap 
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for(int num : nums){
            minheap.add(num);
             if(minheap.size() > k){
                minheap.poll(); // remove the smallest
             }
        }
        return minheap.peek();
    }
}