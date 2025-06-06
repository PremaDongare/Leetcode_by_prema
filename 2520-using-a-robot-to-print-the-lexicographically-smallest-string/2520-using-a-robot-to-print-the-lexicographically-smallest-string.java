class Solution {
    public String robotWithString(String s) {
        int n = s.length();

        // Array to store sorted string
        char[]minchartoright = new char[n];
        minchartoright[n-1]=s.charAt(n-1);
        for(int i=n-2; i>=0; i--){
            minchartoright[i] =(char) Math.min(s.charAt(i),minchartoright[i+1]);

        }
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder paper = new StringBuilder();

        int i=0;
        while(i<n){
            stack.push(s.charAt(i));
            char minchar =(i+1<n) ? minchartoright[i+1] : s.charAt(i);

            while(!stack.isEmpty() && stack.peek()<=minchar){
                paper.append(stack.pop());
            }


            i++;
        }
// the remaining character
        while(!stack.isEmpty()){
            paper.append(stack.pop());
        }
        return paper.toString();

    }
}