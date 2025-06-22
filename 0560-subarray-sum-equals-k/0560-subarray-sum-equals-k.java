class Solution {
    public int subarraySum(int[] nums, int k) {
        int count =0;
        int prefixsum =0;
        Map<Integer,Integer> map= new HashMap<>();
        map.put(0,1);

        // Traverse through array
        for(int i:nums){
            prefixsum +=i;

            //if sum exist in map
            if(map.containsKey(prefixsum-k)){
                count+=map.get(prefixsum-k);
            }
             // update  freq
            map.put(prefixsum, map.getOrDefault(prefixsum,0)+1);
        }
return count;
    }
}