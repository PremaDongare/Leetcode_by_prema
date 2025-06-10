class Solution {
    public int maxDifference(String s) {
        HashMap <Character,Integer> freqmap = new HashMap<>();

        // count frequency
        for(char ch: s.toCharArray()){
            freqmap.put(ch,freqmap.getOrDefault(ch,0)+1);
        }

        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;

        //separate odd and even 
        for(int freq:freqmap.values()){
            if(freq %2 ==1){
                maxOdd =Math.max(maxOdd,freq);
            }else{
                minEven = Math.min(minEven, freq);
            }
        }

return maxOdd - minEven;
    }
}