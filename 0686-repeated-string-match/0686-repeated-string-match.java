class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        // keep repeting untill length of a>= b
        while(sb.length()<b.length()){
            sb.append(a);
            count++;
        }
        // check if b is subst
        if(sb.indexOf(b)!= -1) return count;

        // if not add one more
        sb.append(a);
        count++;
        if(sb.indexOf(b) != -1) return count;

        return -1;
    }
}