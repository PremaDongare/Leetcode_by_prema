class Solution {
    public String findLongestWord(String s, List<String> d) {
       
        String result = ""; 
        
        for(String word : d){
            if(isSubseq(word,s)){
                
                if(word.length() > result.length() || 
                   (word.length() == result.length() && word.compareTo(result) < 0)){  
                    result = word;
                }
            }
        }
        return result;
    }
    
    private boolean isSubseq(String word, String s){
        int j = 0;
        for(int i = 0; i < s.length() && j < word.length(); i++){
            if(s.charAt(i) == word.charAt(j))
                j++;
        }
        
        return j == word.length();  
    }
}