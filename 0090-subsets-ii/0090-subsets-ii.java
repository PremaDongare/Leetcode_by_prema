class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);

        // start back tracking from the begining
        backtrack(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }
    private void backtrack(List<List<Integer>> resultSets, List<Integer> tempSet,int[] nums, int start ){
        // if the set is alredy prensen , just continue
        if(resultSets.contains((tempSet)))
        return;

        resultSets.add(new ArrayList<>(tempSet));

        for(int i=start; i<nums.length; i++){
            tempSet.add(nums[i]);

            //  Backtrack the new subse
            backtrack(resultSets, tempSet, nums, i+1);
            // case of not include the number

            tempSet.remove(tempSet.size()-1);
        }

    }
}