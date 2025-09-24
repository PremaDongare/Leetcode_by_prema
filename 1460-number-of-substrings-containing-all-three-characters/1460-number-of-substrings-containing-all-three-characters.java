class Solution {
    public int numberOfSubstrings(String s) {
        HashMap< Character,Integer> map= new HashMap<>();
        int n = s.length();
        int Left=0;
        int result=0;
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);

            while(map.size()==3){
                result+=(n-i);
            char leftChar= s.charAt(Left);
            map.put(leftChar,map.get(leftChar)-1);
            if(map.get(leftChar)==0){
            map.remove(leftChar);
            }
            Left++;

            }

        }
        return result;
    }
}