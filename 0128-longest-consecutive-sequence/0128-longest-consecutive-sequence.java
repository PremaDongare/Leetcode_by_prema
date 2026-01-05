class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i:nums){
            set.add(i);
        }

        int longestcount=0;

        for(int i:set){
            if(!set.contains(i-1)){
                int currentnum = i;
                int count =1;

                while(set.contains(currentnum+1)){
                    currentnum ++;
                    count++;
                }
             longestcount= Math.max(longestcount, count);
            }
        }
        return longestcount;
        
    }
}