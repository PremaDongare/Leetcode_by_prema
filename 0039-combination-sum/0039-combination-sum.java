class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        solve(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    public void solve(int index, int[] candidates, int target,
                      List<Integer> curr, List<List<Integer>> result) {

        // base case
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        if (index == candidates.length) return;

        // TAKE
        if (candidates[index] <= target) {
            curr.add(candidates[index]);
            solve(index, candidates, target - candidates[index], curr, result);
            curr.remove(curr.size() - 1); //  backtrack
        }

        // SKIP 
        solve(index + 1, candidates, target, curr, result);
    }
}