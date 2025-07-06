class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // count freq 
        Map<Integer, Integer> freqmap = new HashMap<>();
        for(int num :nums){
            freqmap.put(num, freqmap.getOrDefault(num,0)+1);
        }

        // min heap
        PriorityQueue<Map.Entry<Integer, Integer>> minheap = new PriorityQueue<>((a,b)->a.getValue() - b.getValue());

        // heap size
        for(Map.Entry<Integer, Integer> entry : freqmap.entrySet()){
            minheap.offer(entry);
            if(minheap.size()>k){
                minheap.poll(); 
            }
        }
        // print result 
        int [] result = new int [k];
        int i=0;
        while(!minheap.isEmpty()){
            result[i++] = minheap.poll().getKey();
        }

        return result;
    }
}