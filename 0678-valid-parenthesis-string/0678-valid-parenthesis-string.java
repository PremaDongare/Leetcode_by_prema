//using two stacks

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> opstack = new Stack<>();
        Stack<Integer> ststack= new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch= s.charAt(i);
        

        if(ch=='('){
            opstack.push(i);
        } else if(ch == '*'){
            ststack.push(i);
        }else{
            if(!opstack.isEmpty()){
                opstack.pop();
            }else if (!ststack.isEmpty()){
                ststack.pop();
            }else{
                return false;
            }
        }
        }
        // if only ( ( and * is remaining check their incoming index)
        while(!opstack.isEmpty() && !ststack.isEmpty()){
            if(opstack.peek()<ststack.peek()){
                opstack.pop();
                ststack.pop();
            }else{
               return false;
            }
        }
        
     return opstack.isEmpty();

    }
}