class Solution {
    public int firstUniqChar(String s) {
        int index = -1;
        Map<Character, Integer> charMap = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            int freq= charMap.getOrDefault(c,0) ;
            charMap.put(c,(freq+1));

        }
        for(int i=0; i<s.length();i++){
            if(charMap.get(s.charAt(i)) == 1){
                index =i;
                break;
            }
        }
        return index;
    }
}