// keep the majority character and replace the list .

class Solution {
    public int characterReplacement(String s, int k) {
        int freq []= new int[26];
        int l=0;
        int maxfreq = 0; // max freq element in current window 
        int maxlen =0;

        for(int r =0; r<s.length();r++){
         freq[s.charAt(r) - 'A']++;

         //max freq
         maxfreq= Math.max(maxfreq,freq[s.charAt(r)-'A']);
          //check if window is valid
          if((r-l+1)-maxfreq >k){
            //shrink
            freq[s.charAt(l)-'A']--;
            l++;
          }
          //update max length
          maxlen = Math.max(maxlen,r-l+1);
        
        }
        return maxlen;
    }
}