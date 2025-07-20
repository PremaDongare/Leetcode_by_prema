class Solution {

    public static void findCombination(int start, int k, int n, List<Integer>ds, List<List<Integer>> result ){
        if(ds.size() == k){
            if(n==0){
                result.add(new ArrayList<>(ds));
            }
            return;
        }

        for(int i=start; i<=9; i++){
            if(i>n) break;

            ds.add(i); //pick
            findCombination(i+1, k, n-i, ds, result);// recursion
            ds.remove(ds.size()-1); // backtrack


        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        findCombination(1,k,n,new ArrayList<>(), result);
        return result;
    }
}