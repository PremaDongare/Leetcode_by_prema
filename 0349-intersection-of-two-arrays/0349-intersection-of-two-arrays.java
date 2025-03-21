class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resultset = new HashSet<>();

 // Store elements of nums1 in set1
        for(int num: nums1){
            set1.add(num);
        }
        // check if elements of num2 is present in set1
        for(int num: nums2){
            if(set1.contains(num)){
                resultset.add(num);
            }
        }

         // Convert result set to array
         int[] result = new int[resultset.size()];
         int index =0;
         for(int num:resultset){
            result[index++] = num;

         }

             return result; 
    }
}