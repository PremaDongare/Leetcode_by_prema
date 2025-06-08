class Solution {

    public void solve(int curr, int n, List<Integer> result){

        if(curr >n){
            return;
        }
        result.add(curr);

        // generating the next num

        for(int nextdig=0;  nextdig <=9;  nextdig++ ){
            int nextnum = curr * 10 + nextdig;  // 1*10+1 = 11

            if(nextnum > n){
                return;
            }

            solve(nextnum, n, result); // recursive call
        }
    }
    public List<Integer> lexicalOrder(int n) {
       List<Integer> result = new ArrayList<>();

       // start from num 1to 9
       for(int num=1; num <= 9; num++){
        solve(num, n, result);
       } 

       return result;
    }
}