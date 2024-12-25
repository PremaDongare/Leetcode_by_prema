class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int [] lsp = new int[n];
        int length =0; // track prefix sufix match length

        for(int i=1; i<n; i++){
            if(s.charAt(i) == s.charAt(length)){
                length++;
                lsp[i]=length;
            }
            else{
                if(length >0){
                    length = lsp[length-1];
                       i--;
                }else{
                    lsp[i] =0;
                }
            }
        }
        return s.substring(0, lsp[n -1]);
    }
}