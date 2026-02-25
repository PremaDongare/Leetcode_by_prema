//optimize code using sorting for pruning num > target

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0,candidates, target,new ArrayList<>(),result);
        return result;
    }
    public void solve(int index,int[]candidates, int target,List<Integer>curr, List<List<Integer>> result){
        // base case
        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index;i<candidates.length; i++){
            //pruning
            if(candidates[i]>target) break;
            curr.add(candidates[i]);
            solve(i,candidates, target-candidates[i],curr, result);
            curr.remove(curr.size()-1);// backtrack

        }
    }
}