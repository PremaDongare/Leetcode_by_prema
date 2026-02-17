class Solution {
    public boolean isPalindrome(int x) {
        if(x <0) return false;
        String s = String.valueOf(x);
        Stack<Character> st = new Stack<>();

        //step 1 
        for(char ch :s.toCharArray()){
            st.push(ch);
        }
        // step 2
        for(char ch: s.toCharArray()){
            if(ch != st.pop()){
                return false;
            }
        }

        return true;
    }
}