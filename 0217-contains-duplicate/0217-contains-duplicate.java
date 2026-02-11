class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> d = new HashMap<>();
        for(int num: nums){
            d.put(num, d.getOrDefault(num,0)+1 );
            if(d.get(num)>1){
                return true;
            }
        }
        return false;
    }
}