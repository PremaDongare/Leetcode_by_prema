class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }

        // freq of t
        HashMap<Character, Integer> need = new HashMap<>();
        for(char c: t.toCharArray()){
            need.put(c, need.getOrDefault(c,0)+1);
        }

        // sliding wind
         HashMap<Character, Integer> wind = new HashMap<>();
         int left=0, right=0;
         int formed =0;
         int req = need.size();

         //result 
         int minsize= Integer.MAX_VALUE;
         int start=0;

         while(right<s.length()){
            char c = s.charAt(right);
            wind.put(c, wind.getOrDefault(c,0)+1);

            // check
            if(need.containsKey(c) && wind.get(c).intValue() == need.get(c).intValue()){
                formed++;
            }

            // shrink

            while(left <= right && formed == req){
                // update res
                if(right-left+1 < minsize){
                    minsize = right-left+1;
                    start = left;
                }

                char leftchar = s.charAt(left);
                wind.put(leftchar, wind.get(leftchar)-1);

            if (need.containsKey(leftchar) && wind.get(leftchar) < need.get(leftchar))
             { 
                formed--; 
                }
                 left++; 
                 }
                  right++;
                   }
                    return minsize == Integer.MAX_VALUE ? "" : s.substring(start, start + minsize); 
                    } 
                    }